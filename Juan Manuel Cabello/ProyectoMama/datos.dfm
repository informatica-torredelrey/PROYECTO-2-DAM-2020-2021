object Fdatos: TFdatos
  Left = 0
  Top = 0
  Caption = 'Datos'
  ClientHeight = 248
  ClientWidth = 447
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 13
  object Tfamilia: TFDTable
    IndexFieldNames = 'dni'
    Connection = Form1.FDConnection1
    UpdateOptions.UpdateTableName = 'familia'
    TableName = 'familia'
    Left = 72
    Top = 24
    object Tfamiliaexpediente: TStringField
      FieldName = 'expediente'
      Origin = 'expediente'
      ProviderFlags = [pfInUpdate, pfInWhere, pfInKey]
      Required = True
      Size = 11
    end
    object Tfamilianombre: TStringField
      FieldName = 'nombre'
      Origin = 'nombre'
      Required = True
      Size = 40
    end
    object Tfamiliaapellido: TStringField
      FieldName = 'apellido'
      Origin = 'apellido'
      Required = True
      Size = 60
    end
    object Tfamiliaedad: TIntegerField
      FieldName = 'edad'
      Origin = 'edad'
    end
    object Tfamiliasexo: TIntegerField
      FieldName = 'sexo'
      Origin = 'sexo'
      Required = True
    end
    object Tfamiliadni: TStringField
      FieldName = 'dni'
      Origin = 'dni'
      Required = True
      Size = 9
    end
    object Tfamiliamiembroconvivencia: TIntegerField
      FieldName = 'miembroconvivencia'
      Origin = 'miembroconvivencia'
      Required = True
    end
    object Tfamilianumeromenores: TIntegerField
      FieldName = 'numeromenores'
      Origin = 'numeromenores'
      Required = True
    end
    object Tfamiliaunidadfamiliar: TIntegerField
      FieldName = 'unidadfamiliar'
      Origin = 'unidadfamiliar'
      Required = True
    end
    object Tfamiliadiscapacidad: TIntegerField
      FieldName = 'discapacidad'
      Origin = 'discapacidad'
      Required = True
    end
    object Tfamiliamayor65: TIntegerField
      FieldName = 'mayor65'
      Origin = 'mayor65'
      Required = True
    end
    object Tfamiliatotalprestaciones: TFloatField
      FieldName = 'totalprestaciones'
      Origin = 'totalprestaciones'
      Required = True
    end
    object Tfamiliazona: TStringField
      FieldName = 'zona'
      Origin = 'zona'
      Required = True
      Size = 50
    end
    object Tfamiliaequipo: TStringField
      FieldName = 'equipo'
      Origin = 'equipo'
      Required = True
      Size = 70
    end
  end
  object Dfamilia: TDataSource
    DataSet = Tfamilia
    Left = 120
    Top = 24
  end
  object Tgasto: TFDTable
    IndexFieldNames = 'numero'
    Connection = Form1.FDConnection1
    UpdateOptions.UpdateTableName = 'gastos'
    TableName = 'gastos'
    Left = 72
    Top = 80
    object Tgastonumero: TIntegerField
      FieldName = 'numero'
      Origin = 'numero'
      Required = True
    end
    object Tgastodescripcion: TStringField
      FieldName = 'descripcion'
      Origin = 'descripcion'
      Required = True
      Size = 100
    end
    object Tgastomaximo: TFloatField
      FieldName = 'maximo'
      Origin = 'maximo'
    end
  end
  object Dgasto: TDataSource
    DataSet = Tgasto
    Left = 120
    Top = 80
  end
  object Tgasto_detalle: TFDTable
    IndexFieldNames = 'numerogasto'
    Connection = Form1.FDConnection1
    UpdateOptions.UpdateTableName = 'gasto_detalle'
    TableName = 'gasto_detalle'
    Left = 184
    Top = 80
    object Tgasto_detallenumerogasto: TIntegerField
      FieldName = 'numerogasto'
      Origin = 'numerogasto'
      Required = True
    end
    object Tgasto_detallepersona: TIntegerField
      FieldName = 'persona'
      Origin = 'persona'
    end
    object Tgasto_detallemaximo: TFloatField
      FieldName = 'maximo'
      Origin = 'maximo'
    end
  end
  object Dgasto_detalle: TDataSource
    DataSet = Tgasto_detalle
    Left = 264
    Top = 80
  end
  object Tprestacion: TFDTable
    IndexFieldNames = 'expedientefamilia'
    Connection = Form1.FDConnection1
    UpdateOptions.UpdateTableName = 'prestacion'
    TableName = 'prestacion'
    Left = 184
    Top = 24
    object Tprestacionexpedientefamilia: TStringField
      FieldName = 'expedientefamilia'
      Origin = 'expedientefamilia'
      Required = True
      Size = 11
    end
    object Tprestaciontipoprestacion: TStringField
      FieldName = 'tipoprestacion'
      Origin = 'tipoprestacion'
      Required = True
    end
    object Tprestaciondineroprestacion: TFloatField
      FieldName = 'dineroprestacion'
      Origin = 'dineroprestacion'
      Required = True
    end
    object Tprestacionfechaprestacion: TStringField
      FieldName = 'fechaprestacion'
      Origin = 'fechaprestacion'
      Size = 30
    end
    object Tprestacionfechasolicitud: TStringField
      FieldName = 'fechasolicitud'
      Origin = 'fechasolicitud'
      Required = True
      Size = 30
    end
    object Tprestacionfechaado: TStringField
      FieldName = 'fechaado'
      Origin = 'fechaado'
      Size = 30
    end
    object Tprestacionnumeroregistro: TStringField
      FieldName = 'numeroregistro'
      Origin = 'numeroregistro'
      Size = 15
    end
    object Tprestacionobservacion: TWideMemoField
      FieldName = 'observacion'
      Origin = 'observacion'
      BlobType = ftWideMemo
    end
    object Tprestacionnumeroado: TIntegerField
      FieldName = 'numeroado'
      Origin = 'numeroado'
    end
  end
  object Tequipo: TFDTable
    IndexFieldNames = 'equipo'
    Connection = Form1.FDConnection1
    UpdateOptions.UpdateTableName = 'equipo_detalle'
    TableName = 'equipo_detalle'
    Left = 72
    Top = 152
    object Tequipoequipo: TStringField
      FieldName = 'equipo'
      Origin = 'equipo'
      Required = True
      Size = 50
    end
  end
  object Tzona: TFDTable
    IndexFieldNames = 'zonanombre'
    Connection = Form1.FDConnection1
    UpdateOptions.UpdateTableName = 'zona_detalle'
    TableName = 'zona_detalle'
    Left = 184
    Top = 152
    object Tzonazonanombre: TStringField
      FieldName = 'zonanombre'
      Origin = 'zonanombre'
      Required = True
      Size = 50
    end
  end
  object Dequipo: TDataSource
    DataSet = Tequipo
    Left = 120
    Top = 152
  end
  object Dzona: TDataSource
    DataSet = Tzona
    Left = 232
    Top = 152
  end
  object D_prestacion: TDataSource
    DataSet = Tprestacion
    Left = 264
    Top = 32
  end
end
