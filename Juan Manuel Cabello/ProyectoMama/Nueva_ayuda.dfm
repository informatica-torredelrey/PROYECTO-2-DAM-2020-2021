object Fnueva_ayuda: TFnueva_ayuda
  Left = 0
  Top = 0
  Caption = 'Nueva Ayuda'
  ClientHeight = 600
  ClientWidth = 800
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  OnActivate = FormActivate
  OnDestroy = FormDestroy
  PixelsPerInch = 96
  TextHeight = 13
  object Lexpediente: TLabel
    Left = 119
    Top = 8
    Width = 130
    Height = 33
    Caption = 'Expediente'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -27
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
  end
  object Label1: TLabel
    Left = 7
    Top = 15
    Width = 106
    Height = 24
    Caption = 'Expediente:'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -20
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
  end
  object Label9: TLabel
    Left = 144
    Top = 117
    Width = 38
    Height = 13
    Caption = 'Importe'
  end
  object Label10: TLabel
    Left = 464
    Top = 438
    Width = 113
    Height = 13
    Caption = 'Agregar Observaciones'
  end
  object Label11: TLabel
    Left = 144
    Top = 263
    Width = 86
    Height = 13
    Caption = 'Fecha de Solicitud'
  end
  object Label12: TLabel
    Left = 144
    Top = 383
    Width = 54
    Height = 13
    Caption = 'Fecha  Ado'
  end
  object Label13: TLabel
    Left = 144
    Top = 420
    Width = 77
    Height = 13
    Caption = 'Numero registro'
  end
  object Label14: TLabel
    Left = 144
    Top = 460
    Width = 59
    Height = 13
    Caption = 'Numero Ado'
  end
  object Lmaximolabel: TLabel
    Left = 261
    Top = 139
    Width = 3
    Height = 13
  end
  object Label16: TLabel
    Left = 248
    Top = 139
    Width = 4
    Height = 13
    Caption = '/'
  end
  object Label15: TLabel
    Left = 305
    Top = 141
    Width = 44
    Height = 13
    Caption = '(maximo)'
  end
  object Label17: TLabel
    Left = 144
    Top = 303
    Width = 97
    Height = 13
    Caption = 'Fecha de Prestaci'#243'n'
  end
  object Panel: TPanel
    Left = 521
    Top = 15
    Width = 249
    Height = 201
    TabOrder = 0
    object L1: TLabel
      Left = 16
      Top = 176
      Width = 112
      Height = 13
      Caption = 'Maximo por prestacion:'
    end
    object Limporte: TLabel
      Left = 160
      Top = 176
      Width = 38
      Height = 13
      Caption = 'Importe'
    end
    object Label8: TLabel
      Left = -216
      Top = 88
      Width = 31
      Height = 13
      Caption = 'Label8'
    end
    object Mdescripcion: TMemo
      Left = 8
      Top = 8
      Width = 233
      Height = 113
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -13
      Font.Name = 'Tahoma'
      Font.Style = []
      ParentFont = False
      ReadOnly = True
      TabOrder = 0
    end
  end
  object DBGrid1: TDBGrid
    Left = 7
    Top = 88
    Width = 90
    Height = 120
    DataSource = Fdatos.Dgasto
    Options = [dgColumnResize, dgColLines, dgRowLines, dgTabs, dgConfirmDelete, dgCancelOnExit, dgTitleClick, dgTitleHotTrack]
    TabOrder = 1
    TitleFont.Charset = DEFAULT_CHARSET
    TitleFont.Color = clWindowText
    TitleFont.Height = -11
    TitleFont.Name = 'Tahoma'
    TitleFont.Style = []
    OnCellClick = DBGrid1CellClick
    Columns = <
      item
        Expanded = False
        FieldName = 'numero'
        Width = 50
        Visible = True
      end>
  end
  object Ppersona: TPanel
    Left = 521
    Top = 263
    Width = 249
    Height = 114
    TabOrder = 2
    object Lpersona1: TLabel
      Left = 66
      Top = 8
      Width = 50
      Height = 13
      Caption = 'Lpersona1'
    end
    object Lpersona2: TLabel
      Left = 71
      Top = 40
      Width = 31
      Height = 13
      Caption = 'Label2'
    end
    object Lpersona3: TLabel
      Left = 71
      Top = 72
      Width = 31
      Height = 13
      Caption = 'Label2'
    end
    object Lpersona4: TLabel
      Left = 202
      Top = 8
      Width = 31
      Height = 13
      Caption = 'Label2'
    end
    object Lpersona5: TLabel
      Left = 202
      Top = 40
      Width = 31
      Height = 13
      Caption = 'Label2'
    end
    object Lpersona6: TLabel
      Left = 202
      Top = 72
      Width = 31
      Height = 13
      Caption = 'Label2'
    end
    object Label2: TLabel
      Left = 8
      Top = 8
      Width = 52
      Height = 13
      Caption = '1 Persona:'
    end
    object Label3: TLabel
      Left = 8
      Top = 40
      Width = 57
      Height = 13
      Caption = '2 Personas:'
    end
    object Label4: TLabel
      Left = 8
      Top = 72
      Width = 57
      Height = 13
      Caption = '3 Personas:'
    end
    object Label5: TLabel
      Left = 139
      Top = 8
      Width = 57
      Height = 13
      Caption = '4 Personas:'
    end
    object Label6: TLabel
      Left = 139
      Top = 40
      Width = 57
      Height = 13
      Caption = '5 Personas:'
    end
    object Label7: TLabel
      Left = 139
      Top = 72
      Width = 57
      Height = 13
      Caption = '6 Personas:'
    end
  end
  object Button1: TButton
    Left = 263
    Top = 536
    Width = 98
    Height = 45
    Caption = 'Asignar Ayuda'
    TabOrder = 3
    OnClick = Button1Click
  end
  object EimporteIngresar: TEdit
    Left = 144
    Top = 136
    Width = 98
    Height = 21
    TabOrder = 4
  end
  object DateSolicitud: TDateTimePicker
    Left = 254
    Top = 263
    Width = 107
    Height = 21
    Date = 44234.000000000000000000
    Time = 0.452826608794566700
    TabOrder = 5
  end
  object ChAdo: TCheckBox
    Left = 122
    Top = 382
    Width = 16
    Height = 17
    TabOrder = 6
    OnClick = ChAdoClick
  end
  object ChNumeroAdo: TCheckBox
    Left = 122
    Top = 459
    Width = 16
    Height = 17
    TabOrder = 7
    OnClick = ChNumeroAdoClick
  end
  object DateAdo: TDateTimePicker
    Left = 254
    Top = 382
    Width = 107
    Height = 21
    Date = 44234.000000000000000000
    Time = 0.452826608794566700
    TabOrder = 8
  end
  object ENumeroAdo: TEdit
    Left = 254
    Top = 457
    Width = 121
    Height = 21
    TabOrder = 9
  end
  object ENumeroRegistro: TEdit
    Left = 254
    Top = 422
    Width = 121
    Height = 21
    TabOrder = 10
  end
  object Bcancelar: TButton
    Left = 8
    Top = 536
    Width = 98
    Height = 45
    Caption = 'Cancelar'
    TabOrder = 11
    OnClick = BcancelarClick
  end
  object DatePrestacion: TDateTimePicker
    Left = 254
    Top = 303
    Width = 107
    Height = 21
    Date = 44234.000000000000000000
    Time = 0.452826608794566700
    TabOrder = 12
  end
  object ChPrestacion: TCheckBox
    Left = 122
    Top = 302
    Width = 16
    Height = 17
    TabOrder = 13
    OnClick = ChPrestacionClick
  end
  object DBMemo1: TDBMemo
    Left = 464
    Top = 457
    Width = 290
    Height = 89
    DataField = 'observacion'
    DataSource = Fdatos.D_prestacion
    TabOrder = 14
  end
end
