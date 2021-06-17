/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;


import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.ibatis.jdbc.ScriptRunner;



/**
 *
 * @author admin
 */
public class Conexion {
    
    private static final String IP_DEFECTO = "localhost";
    private static final String USUARIO_DEFECTO = "root";
    private static final String PASS_DEFECTO = "root";
    
    private static String ip,usuario,pass;
    private static boolean activo = false;
    
    private static Connection conexion = null;
    
//---------------------------------------------------------------CODIGO RELACIONADO CON LA BASE DE DATOS---------------------------------------------------------------
    
    //Para obtener conexion
    public static Connection obtenerConexion(){
        try {
            //En caso de que haya metido las credenciales, entrará con las credenciales del usuario, en caso contrario usará las que tiene por defecto
            if (activo){
                conexion = DriverManager.getConnection("jdbc:mysql://"+ip+"/inventario_instituto?serverTimezone=UTC", usuario, pass);
            }else{
                conexion = DriverManager.getConnection("jdbc:mysql://"+IP_DEFECTO+"/inventario_instituto?serverTimezone=UTC", USUARIO_DEFECTO, PASS_DEFECTO);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos.\nPor favor, compruebe que las credenciales son correctas","Error",JOptionPane.ERROR_MESSAGE);
            conexion = null;
            retornaLogin();
        }
        
        return conexion;
    }
    
    //Para crear la base de datos
    public static void crearBase(){    
        try{
            if (activo){
                conexion = DriverManager.getConnection("jdbc:mysql://"+ip+"?serverTimezone=UTC", usuario, pass);
            }else{
                conexion = DriverManager.getConnection("jdbc:mysql://"+IP_DEFECTO+"?serverTimezone=UTC", USUARIO_DEFECTO, PASS_DEFECTO);
            }
            
            if(conexion!=null){
                InputStream is = Conexion.class.getResourceAsStream("/Recursos/inventario.sql");
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                ScriptRunner sr = new ScriptRunner(conexion);

                sr.runScript(br);
                
                JOptionPane.showMessageDialog(null,"Base de datos creada con exito","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al conectarse a la base de datos.\nPor favor, compruebe que las credenciales son correctas","Error",JOptionPane.ERROR_MESSAGE);
            conexion = null;
            retornaLogin();
        }
    }
    
    //En caso de error vuelve al inicio
    private static void retornaLogin() {
        
    }
    
//---------------------------------------------------------------CODIGO RELACIONADO CON CONSULTAS AL USUARIO---------------------------------------------------------------
    
    //Funcion que recoje el usuario de la base de datos en base al email
    public static Usuario recogeUsuario(String email){
        //Recoge el usuario con el email
        Usuario user=null;
        try {
            conexion = obtenerConexion();
            if (conexion != null){
                PreparedStatement ps = conexion.prepareStatement("select * from usuario where email=?");
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();

                while (rs.next()){
                    user = new Usuario (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                }
                
                if(user == null){
                    JOptionPane.showMessageDialog(null,"Ese usuario no existe en la base de datos","Error al iniciar sesión",JOptionPane.ERROR_MESSAGE);
                }
                conexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    //Recoge usuario en base al id
    public static Usuario recogeUsuarioId(String id){
        Usuario user=null;
        try {
            conexion = obtenerConexion();
            if (conexion != null){
                PreparedStatement ps = conexion.prepareStatement("select * from usuario where idusuario=?");
                ps.setString(1, id);
                ResultSet rs = ps.executeQuery();

                while (rs.next()){
                    user = new Usuario (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                }       
                conexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    //Funcion de cambiar la contraseña
    public static void cambiarPass(String nueva,int id) {
        try {
            conexion = obtenerConexion();
            if(conexion != null){
                PreparedStatement ps = conexion.prepareStatement("UPDATE `inventario_instituto`.`usuario` SET `password`=? WHERE  `idusuario`=?");
                ps.setString(1, EncriptaPass.StringToHash(nueva));
                ps.setInt(2, id);

                ps.executeUpdate();

                conexion.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Funcion de agregar usuario
    public static boolean addUser(String nombre, String apellido, String email, String tipo) {
        boolean result = false;
        try {
            conexion = obtenerConexion();
            if(conexion != null){
                String alta = "INSERT INTO `inventario_instituto`.`usuario` (`nombre`, `apellido`, `email`, `password`, `tipo`) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = conexion.prepareStatement(alta);

                ps.setString(1, nombre);
                ps.setString(2, apellido);
                ps.setString(3, email);
                ps.setString(4, EncriptaPass.StringToHash("usuario"));
                ps.setString(5, tipo.toLowerCase());

                ps.executeUpdate();

                conexion.close();

                JOptionPane.showMessageDialog(null,"Usuario insertado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);

                result = true;
            }
        } catch(SQLIntegrityConstraintViolationException ex){
            JOptionPane.showMessageDialog(null,"El email ya esta registrado en la base de datos","Error",JOptionPane.ERROR_MESSAGE);
        }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    //Funcion de modificar usuario
    public static boolean modifUser(String nombre, String apellido, String email, String pass, String tipo, String id) {
        
        boolean result = false;
        
        try{
            conexion = obtenerConexion();
            if(conexion != null){
                String modif="UPDATE `inventario_instituto`.`usuario` SET `nombre`=?, `apellido`=?, `email`=?, `password`=?, `tipo`=? WHERE `idusuario`=?";
                PreparedStatement ps = conexion.prepareStatement(modif);

                ps.setString(1, nombre);
                ps.setString(2, apellido);
                ps.setString(3, email);
                ps.setString(4, EncriptaPass.StringToHash(pass));
                ps.setString(5, tipo.toLowerCase());
                ps.setString(6, id);

                ps.executeUpdate();

                conexion.close();

                JOptionPane.showMessageDialog(null,"Usuario modificado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);

                result = true;
            }
        }catch(SQLIntegrityConstraintViolationException ex){
            JOptionPane.showMessageDialog(null,"El email ya esta registrado en la base de datos","Error",JOptionPane.ERROR_MESSAGE);
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
        
    }
    
    //Funcion de eliminar a un usuario
    public static void deleteUser(String entrada) {
        try {
            conexion = obtenerConexion();
            if(conexion!=null){
                String elim = "DELETE FROM `inventario_instituto`.`usuario` where `idusuario`=?";
                PreparedStatement ps = conexion.prepareStatement(elim);

                ps.setString(1, entrada);

                ps.executeUpdate();

                conexion.close();

                JOptionPane.showMessageDialog(null,"Usuario eliminado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//---------------------------------------------------------------CODIGO RELACIONADO CON CONSULTAS A LOS MATERIALES---------------------------------------------------------------
    //Recoje los datos para rellenarlos en los comboboxes
    public static String[] getDatos(String dato) {
        List<String> datos = new ArrayList<>();
        try {  
            conexion = obtenerConexion();
            if(conexion!=null){
                PreparedStatement ps = conexion.prepareStatement("select * from "+dato);

                ResultSet rs = ps.executeQuery();

                while(rs.next()){
                    switch(dato){
                        case "localizacion":
                            datos.add(rs.getString(1));
                            break;
                        case "tipo_material":
                            datos.add(rs.getString(1)+"# "+rs.getString(2));
                            break;
                        case "proveedor":
                            datos.add(String.valueOf(rs.getInt(1))+"# "+rs.getString(2)+" "+rs.getString(3));
                            break;
                        case "material":
                            datos.add(rs.getString(1));
                            break;
                        case "usuario":
                            datos.add(String.valueOf(rs.getInt(1))+"# "+rs.getString(2)+" "+rs.getString(3));
                            break;
                    }
                }
                conexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos.toArray(new String[datos.size()]);
    }
    
    //Agrega un material a la base de datos
    public static boolean addMaterial(String nombre, String tipo, String marca, String proveedor, String localizacion, String stock, String precio) {
        boolean result = false;
        try {
            conexion = obtenerConexion();
            if(conexion!=null){
                String alta = "INSERT INTO `inventario_instituto`.`material` (`nombre`, `tipo`, `marca`, `stock`, `localizacion`, `proveedor`, `precio_unitario`) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conexion.prepareStatement(alta);

                ps.setString(1, nombre.toLowerCase());
                ps.setString(2, tipo);
                ps.setString(3, marca);
                ps.setString(4, stock);
                ps.setString(5, localizacion);
                ps.setString(6, proveedor);
                ps.setString(7, precio);

                ps.executeUpdate();

                conexion.close();

                JOptionPane.showMessageDialog(null,"Material insertado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);

                result = true;
            }
            
        } catch(SQLIntegrityConstraintViolationException ex){
            JOptionPane.showMessageDialog(null,"Ese material ya esta registrado en la base de datos","Error",JOptionPane.ERROR_MESSAGE);
        }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    //Recoje un material introducido por el usuario
    public static Material recogeMaterial(String nombreMaterial) {
        Material material = null;
        try {
            conexion = obtenerConexion();
            if(conexion!=null){
                PreparedStatement ps = conexion.prepareStatement("SELECT material.nombre,material.tipo,material.marca,material.stock,material.localizacion,material.proveedor,tipo_material.nombre,proveedor.nombre,proveedor.apellido,material.dado_de_baja,material.precio_unitario FROM material,tipo_material,proveedor WHERE material.nombre = '"+nombreMaterial+"' AND tipo_material.codigo = tipo AND proveedor.idproveedor = material.proveedor");

                ResultSet rs = ps.executeQuery();

                while (rs.next()){
                    material = new Material (rs.getString(1),rs.getString(2)+"# "+rs.getString(7),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6)+"# "+rs.getString(8)+ " " + rs.getString(9),(rs.getString(10).equals("no")),rs.getDouble(11));
                }

                conexion.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return material;
    }
    
    //Recoje todos los materiales
    public static List<Material> recogeMateriales(){
        List<Material> materiales = new ArrayList<>();
        try {
            conexion = obtenerConexion();
            if(conexion!=null){
                PreparedStatement ps = conexion.prepareStatement("SELECT material.nombre,material.tipo,material.marca,material.stock,material.localizacion,material.proveedor,tipo_material.nombre,proveedor.nombre,proveedor.apellido,material.dado_de_baja,material.precio_unitario FROM material,tipo_material,proveedor WHERE tipo_material.codigo = tipo AND proveedor.idproveedor = material.proveedor");

                ResultSet rs = ps.executeQuery();

                while (rs.next()){
                    materiales.add(new Material (rs.getString(1),rs.getString(2)+"# "+rs.getString(7),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6)+"# "+rs.getString(8)+ " " + rs.getString(9),(rs.getString(10).equals("no")),rs.getDouble(11)));
                }

                conexion.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materiales;        
    }
    
    //Recoje materiales con un campo especifico
    public static List<Material> recogeMateriales(String buscar, String campo) {
        List<Material> materiales = new ArrayList<>();
        String columna = (campo.equals("Disponible")?"dado_de_baja":campo.toLowerCase());
        
        if(columna.equals("dado_de_baja")){
            buscar = (buscar.equals("si")?"no":"si");
        }
        try {
            conexion = obtenerConexion();
            if(conexion!=null){
                PreparedStatement ps = conexion.prepareStatement("SELECT material.nombre,material.tipo,material.marca,material.stock,material.localizacion,material.proveedor,tipo_material.nombre,proveedor.nombre,proveedor.apellido,material.dado_de_baja,material.precio_unitario FROM material,tipo_material,proveedor WHERE tipo_material.codigo = tipo AND proveedor.idproveedor = material.proveedor AND material."+columna+" = ?");
                ps.setString(1, buscar);

                ResultSet rs = ps.executeQuery();

                while (rs.next()){
                    materiales.add(new Material (rs.getString(1),rs.getString(2)+"# "+rs.getString(7),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6)+"# "+rs.getString(8)+ " " + rs.getString(9),(rs.getString(10).equals("no")), rs.getDouble(11)));
                }

                conexion.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materiales;
    }
    
    //Editar material
    public static boolean modifMaterial(String nombre, String tipo, String marca, String proveedor, String localizacion, String stock, String precio) {
        boolean result = false;
        try {
            conexion = obtenerConexion();
            
            if(conexion!=null){
                String modif = "UPDATE `inventario_instituto`.`material` SET `tipo`=?, `marca`=?, `stock`=?, `localizacion`=?, `proveedor`=?, `precio_unitario`=? WHERE  `nombre`=?";
                PreparedStatement ps = conexion.prepareStatement(modif);

                System.out.println("");

                ps.setString(1, tipo);
                ps.setString(2, marca);
                ps.setString(3, stock);
                ps.setString(4, localizacion);
                ps.setString(5, proveedor);
                ps.setString(6, precio);
                ps.setString(7, nombre);


                ps.executeUpdate();

                JOptionPane.showMessageDialog(null,"Material modificado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);

                conexion.close();
                result = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    //Eliminar material
    public static void deleteMaterial(String entrada, String altaBaja) {
        try {
            conexion = obtenerConexion();
            if(conexion!=null){
                String elim = "UPDATE `inventario_instituto`.`material` SET `dado_de_baja`=? WHERE  `nombre`=?;";
                PreparedStatement ps = conexion.prepareStatement(elim);

                ps.setString(1, altaBaja);
                ps.setString(2, entrada);

                ps.executeUpdate();

                conexion.close();
                if(altaBaja.equals("si")){
                    JOptionPane.showMessageDialog(null,"Material dado de baja correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"Material dado de alta nuevamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    //Asignar localizacion
    public static void guardarLoc(String material, String localizacion) {
        try {
            conexion = obtenerConexion();
            if(conexion!=null){
                String loc = "UPDATE `inventario_instituto`.`material` SET `localizacion`=? WHERE  `nombre`=?;";
                PreparedStatement ps = conexion.prepareStatement(loc);

                ps.setString(1, localizacion);
                ps.setString(2, material);

                ps.executeUpdate();

                conexion.close();

                JOptionPane.showMessageDialog(null,"Localizacion asignada correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//---------------------------------------------------------------CODIGO RELACIONADO CON CONSULTAS DE PROVEEDORES---------------------------------------------------------------
    
    //Recoje un proveedor
    public static Proveedor recogeProveedor(String idProveedor) {
        Proveedor prov = null;        
        try {
            conexion = obtenerConexion();
            if (conexion != null){
                PreparedStatement ps = conexion.prepareStatement("select * from proveedor where idproveedor="+idProveedor);
                ResultSet rs = ps.executeQuery();

                while (rs.next()){
                    prov = new Proveedor (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                }       
                conexion.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return prov;
    }
    
    //Elimina a un proveedor
    public static void deleteProveedor(String entrada) {
        try {
            conexion = obtenerConexion();
            if(conexion!=null){
                String elim = "DELETE FROM `inventario_instituto`.`proveedor` where `idproveedor`=?";
                PreparedStatement ps = conexion.prepareStatement(elim);

                ps.setString(1, entrada);

                ps.executeUpdate();

                conexion.close();

                JOptionPane.showMessageDialog(null,"Proveedor eliminado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLIntegrityConstraintViolationException es){
            JOptionPane.showMessageDialog(null,"Actualmente este proveedor esta asignado a un material y por lo tanto no se puede eliminar","Error",JOptionPane.ERROR_MESSAGE);
        }
        catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Alta de proveedor
    public static boolean altaProveedor(String nombre, String apellido, String email, String telefono) {
        boolean result = false;
        try {
            conexion = obtenerConexion();
            
            if(conexion!=null){
                String alta = "INSERT INTO `inventario_instituto`.`proveedor` (`nombre`, `apellido`, `email`, `telefono`) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = conexion.prepareStatement(alta);

                ps.setString(1, nombre);
                ps.setString(2, apellido);
                ps.setString(3, email);
                ps.setString(4, telefono);

                ps.executeUpdate();

                conexion.close();

                result = true;

                JOptionPane.showMessageDialog(null,"Proveedor insertado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch(MysqlDataTruncation ex){
            JOptionPane.showMessageDialog(null,"El telefono solo puede tener nueve digitos numericos","Error",JOptionPane.ERROR_MESSAGE);
        }catch(SQLIntegrityConstraintViolationException ex){
            JOptionPane.showMessageDialog(null,"El telefono o el email ya estan recogidos en la base de datos","Error",JOptionPane.ERROR_MESSAGE);
        }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    //Modificar proveedor
    public static boolean modificaProveedor(String nombre, String apellido, String email, String telefono, String idproveedor) {
        boolean result = false;
        try {
            conexion = obtenerConexion();
            
            if(conexion!=null){
                String modif = "UPDATE `inventario_instituto`.`proveedor` SET `nombre`=?, `apellido`=?, `email`=?, `telefono`=? where `idproveedor` = ?";
                PreparedStatement ps = conexion.prepareStatement(modif);

                ps.setString(1, nombre);
                ps.setString(2, apellido);
                ps.setString(3, email);
                ps.setString(4, telefono);
                ps.setString(5, idproveedor);

                ps.executeUpdate();

                JOptionPane.showMessageDialog(null,"Proveedor modificado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);

                conexion.close();

                result = true;
            }
        } catch(SQLIntegrityConstraintViolationException ex){
            JOptionPane.showMessageDialog(null,"El telefono o el email ya estan recogidos en la base de datos","Error",JOptionPane.ERROR_MESSAGE);
        }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
//---------------------------------------------------------------CODIGO RELACIONADO CON CONSULTAS DE LOCALIZACIONES---------------------------------------------------------------
    
    public static void añadirLoc(String entrada) {
        try {
            conexion = obtenerConexion();
            
            if(conexion!=null){
                String alta = "INSERT INTO `inventario_instituto`.`localizacion` (`nombre`) VALUES (?)";
                PreparedStatement ps = conexion.prepareStatement(alta);

                ps.setString(1, entrada);

                ps.executeUpdate();

                conexion.close();

                JOptionPane.showMessageDialog(null,"Localizacion insertada correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch(SQLIntegrityConstraintViolationException ex){
            JOptionPane.showMessageDialog(null,"Esa localizacion ya esta registrada","Error",JOptionPane.ERROR_MESSAGE);
        }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public static void eliminaLoc(String eleccion) {
        try {
            conexion = obtenerConexion();
            if(conexion!=null){
                String elim = "DELETE FROM `inventario_instituto`.`localizacion` where `nombre`=?";
                PreparedStatement ps = conexion.prepareStatement(elim);

                ps.setString(1, eleccion);

                ps.executeUpdate();

                conexion.close();

                JOptionPane.showMessageDialog(null,"Localizacion eliminada correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLIntegrityConstraintViolationException ex){
            JOptionPane.showMessageDialog(null,"Hay materiales en esa localizacion, por lo tanto no se puede borrar","Error",JOptionPane.ERROR_MESSAGE);
        }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//---------------------------------------------------------------CODIGO RELACIONADO CON CONSULTAS DE TIPOS---------------------------------------------------------------

    public static void añadirTipo(String nombre, String codigo) {
        try {
            conexion = obtenerConexion();
            
            if(conexion!=null){
                String alta = "INSERT INTO `inventario_instituto`.`tipo_material` (`codigo`,`nombre`) VALUES (?,?)";
                PreparedStatement ps = conexion.prepareStatement(alta);

                ps.setString(1, codigo);
                ps.setString(2, nombre.toLowerCase());

                ps.executeUpdate();

                conexion.close();

                JOptionPane.showMessageDialog(null,"Tipo insertado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLIntegrityConstraintViolationException ex){
            JOptionPane.showMessageDialog(null,"Ese tipo ya esta registrado en la base de datos","Error",JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public static void eliminaTipo(String eleccion) {
        try {
            conexion = obtenerConexion();
            if(conexion!=null){
                String elim = "DELETE FROM `inventario_instituto`.`tipo_material` where `codigo`=?";
                PreparedStatement ps = conexion.prepareStatement(elim);

                ps.setString(1, eleccion);

                ps.executeUpdate();

                conexion.close();

                JOptionPane.showMessageDialog(null,"Tipo eliminado correctamente","Informacion",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(SQLIntegrityConstraintViolationException ex){
            JOptionPane.showMessageDialog(null,"Hay materiales que tienen ese tipo, por lo tanto no se puede borrar","Error",JOptionPane.ERROR_MESSAGE);
        }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
//---------------------------------------------------------------CODIGO RELACIONADO CON EL HISTORIAL---------------------------------------------------------------
    
    //Recoje todo el historial
    public static List<Historial> recogeHistorial() {
        List<Historial> historial = new ArrayList<>();
        try {
            conexion = obtenerConexion();
            if(conexion!=null){
                PreparedStatement ps = conexion.prepareStatement("SELECT * from historial");

                ResultSet rs = ps.executeQuery();

                while (rs.next()){
                    historial.add(new Historial (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
                }

                conexion.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return historial; 
    }

    //Recoje el historial de un material en especifico
    public static List<Historial> recogeHistorial(String buscar) {
        List<Historial> historial = new ArrayList<>();
        try {
            conexion = obtenerConexion();
            if(conexion!=null){
                PreparedStatement ps = conexion.prepareStatement("SELECT * from historial where material = ?");
                ps.setString(1, buscar);

                ResultSet rs = ps.executeQuery();

                while (rs.next()){
                    historial.add(new Historial (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
                }

                conexion.close();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return historial; 
    }
    
    //Para guardar el historial
    public static void guardarHistorial(String material, String localizacion, String fecha, String user) {
        try {
            conexion = obtenerConexion();
            
            if(conexion!=null){
                String alta = "INSERT INTO `inventario_instituto`.`historial` (`material`,`localizacion`,`fecha`,`user`) VALUES (?,?,?,?)";
                PreparedStatement ps = conexion.prepareStatement(alta);

                ps.setString(1, material);
                ps.setString(2, localizacion);
                ps.setString(3, fecha);
                ps.setString(4, user);

                ps.executeUpdate();

                conexion.close();
            }
        }catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }    
//---------------------------------------------------------------GETTERS Y SETTERS---------------------------------------------------------------
    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        Conexion.ip = ip;
    }

    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        Conexion.usuario = usuario;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        Conexion.pass = pass;
    }

    public static boolean isActivo() {
        return activo;
    }

    public static void setActivo(boolean activo) {
        Conexion.activo = activo;
    } 

}
