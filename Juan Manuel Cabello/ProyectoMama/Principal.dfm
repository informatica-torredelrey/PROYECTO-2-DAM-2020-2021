object Form1: TForm1
  Left = 0
  Top = 0
  Caption = 'Gestion de Servicios Sociales'
  ClientHeight = 341
  ClientWidth = 454
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  Menu = MainMenu1
  OldCreateOrder = False
  OnActivate = FormActivate
  OnDestroy = FormDestroy
  PixelsPerInch = 96
  TextHeight = 13
  object Bnueva_familia: TButton
    Left = 144
    Top = 48
    Width = 145
    Height = 49
    Caption = 'Nueva Familia'
    TabOrder = 0
    OnClick = NuevaFamilia1Click
  end
  object Blistado: TButton
    Left = 144
    Top = 160
    Width = 145
    Height = 57
    Caption = 'Listado de Familias'
    TabOrder = 1
    OnClick = ListadodeFamilias1Click
  end
  object Bsalir: TButton
    Left = 144
    Top = 284
    Width = 145
    Height = 49
    Caption = 'Salir'
    TabOrder = 2
    OnClick = BsalirClick
  end
  object MainMenu1: TMainMenu
    Left = 8
    Top = 8
    object Familias1: TMenuItem
      Caption = 'Familias'
      object NuevaFamilia1: TMenuItem
        Caption = 'Nueva Familia'
        OnClick = NuevaFamilia1Click
      end
      object ListadodeFamilias1: TMenuItem
        Caption = 'Listado de Familias'
        OnClick = ListadodeFamilias1Click
      end
    end
  end
  object FDConnection1: TFDConnection
    Params.Strings = (
      
        'Database=C:\Users\Juanma\Desktop\ProyectoMama\Win32\Debug\BaseDe' +
        'Datos.db'
      'DriverID=SQLite')
    Connected = True
    LoginPrompt = False
    Left = 352
    Top = 8
  end
end
