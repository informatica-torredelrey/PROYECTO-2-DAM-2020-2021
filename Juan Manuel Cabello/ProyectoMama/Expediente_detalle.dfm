object FdetalleExpediente: TFdetalleExpediente
  Left = 0
  Top = 0
  Caption = 'Informaci'#243'n de Expediente'
  ClientHeight = 459
  ClientWidth = 793
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
  object Lnombre: TLabel
    Left = 72
    Top = 80
    Width = 50
    Height = 16
    Caption = 'Lnombre'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
  end
  object Lapellido: TLabel
    Left = 72
    Top = 112
    Width = 37
    Height = 16
    Caption = 'Label1'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
  end
  object Ledad: TLabel
    Left = 72
    Top = 144
    Width = 37
    Height = 16
    Caption = 'Label1'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
  end
  object Ldni: TLabel
    Left = 72
    Top = 53
    Width = 37
    Height = 16
    Caption = 'Label1'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
  end
  object Lsexo: TLabel
    Left = 72
    Top = 184
    Width = 37
    Height = 16
    Caption = 'Label1'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
  end
  object Lexpediente: TLabel
    Left = 40
    Top = 16
    Width = 116
    Height = 23
    Caption = 'Lexpediente'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -19
    Font.Name = 'Tahoma'
    Font.Style = [fsBold]
    ParentFont = False
  end
  object Label2: TLabel
    Left = 312
    Top = 37
    Width = 148
    Height = 16
    Caption = 'Miembros de convivencia:'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
  end
  object Label3: TLabel
    Left = 312
    Top = 77
    Width = 121
    Height = 16
    Caption = 'Numero de Menores:'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
  end
  object Label4: TLabel
    Left = 312
    Top = 117
    Width = 94
    Height = 16
    Caption = 'Unidad Familiar:'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
  end
  object Lmiembroconvivencia: TLabel
    Left = 466
    Top = 37
    Width = 7
    Height = 16
    Caption = '0'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
  end
  object Lmenores: TLabel
    Left = 466
    Top = 77
    Width = 7
    Height = 16
    Caption = '0'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
  end
  object Lunidadfamiliar: TLabel
    Left = 466
    Top = 117
    Width = 7
    Height = 16
    Caption = '0'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
  end
  object Label5: TLabel
    Left = 312
    Top = 168
    Width = 164
    Height = 16
    Caption = 'Personas con discapacidad?:'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
  end
  object Label6: TLabel
    Left = 312
    Top = 208
    Width = 95
    Height = 16
    Caption = 'Mayores de 65?:'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
  end
  object Ldiscapacidad: TLabel
    Left = 482
    Top = 168
    Width = 7
    Height = 16
    Caption = '0'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
  end
  object Lmayores: TLabel
    Left = 482
    Top = 208
    Width = 7
    Height = 16
    Caption = '0'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -13
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
  end
  object Label1: TLabel
    Left = 176
    Top = 267
    Width = 103
    Height = 23
    Caption = 'Prestaciones'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -19
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
  end
  object Label7: TLabel
    Left = 666
    Top = 272
    Width = 95
    Height = 18
    Caption = 'Observaciones'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -15
    Font.Name = 'Tahoma'
    Font.Style = []
    ParentFont = False
  end
  object DBGrid1: TDBGrid
    Left = 26
    Top = 296
    Width = 543
    Height = 144
    DataSource = Fdatos.D_prestacion
    Options = [dgTitles, dgColumnResize, dgColLines, dgRowLines, dgTabs, dgConfirmDelete, dgCancelOnExit, dgTitleClick, dgTitleHotTrack]
    TabOrder = 0
    TitleFont.Charset = DEFAULT_CHARSET
    TitleFont.Color = clWindowText
    TitleFont.Height = -11
    TitleFont.Name = 'Tahoma'
    TitleFont.Style = []
    Columns = <
      item
        Expanded = False
        FieldName = 'expedientefamilia'
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'tipoprestacion'
        Width = 60
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'dineroprestacion'
        Width = 64
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'fechaprestacion'
        Width = 100
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'fechasolicitud'
        Width = 100
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'numeroregistro'
        Width = 64
        Visible = True
      end>
  end
  object MemoObservaciones: TDBMemo
    Left = 592
    Top = 296
    Width = 186
    Height = 144
    DataField = 'observacion'
    ReadOnly = True
    TabOrder = 1
  end
  object Button1: TButton
    Left = 645
    Top = 8
    Width = 116
    Height = 25
    Caption = 'Modificar Expediente'
    TabOrder = 2
    OnClick = Button1Click
  end
  object BmodificarAyuda: TButton
    Left = 645
    Top = 235
    Width = 116
    Height = 25
    Caption = 'Modificar Ayuda'
    TabOrder = 3
    OnClick = BmodificarAyudaClick
  end
  object Button2: TButton
    Left = 645
    Top = 100
    Width = 116
    Height = 43
    Caption = 'Dar Prestaci'#243'n'
    Enabled = False
    TabOrder = 4
    OnClick = Button2Click
  end
end
