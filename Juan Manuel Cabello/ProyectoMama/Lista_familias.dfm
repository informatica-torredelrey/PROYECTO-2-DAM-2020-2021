object Flista_familias: TFlista_familias
  Left = 0
  Top = 0
  Caption = 'Lista de Familias'
  ClientHeight = 428
  ClientWidth = 709
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
  object Label1: TLabel
    Left = 360
    Top = 335
    Width = 55
    Height = 13
    Caption = 'Buscar Por:'
  end
  object Label2: TLabel
    Left = 417
    Top = 288
    Width = 31
    Height = 13
    Caption = 'Label2'
  end
  object DBGrid1: TDBGrid
    Left = 24
    Top = 8
    Width = 649
    Height = 257
    DataSource = Fdatos.Dfamilia
    Options = [dgTitles, dgIndicator, dgColumnResize, dgColLines, dgRowLines, dgTabs, dgConfirmDelete, dgCancelOnExit, dgTitleClick, dgTitleHotTrack]
    TabOrder = 0
    TitleFont.Charset = DEFAULT_CHARSET
    TitleFont.Color = clWindowText
    TitleFont.Height = -11
    TitleFont.Name = 'Tahoma'
    TitleFont.Style = []
    Columns = <
      item
        Expanded = False
        FieldName = 'expediente'
        Width = 59
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'nombre'
        Width = 135
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'apellido'
        Width = 139
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'edad'
        Visible = True
      end
      item
        Expanded = False
        FieldName = 'dni'
        Visible = True
      end>
  end
  object Basignar: TButton
    Left = 24
    Top = 288
    Width = 97
    Height = 41
    Caption = 'A'#241'adir una ayuda'
    TabOrder = 1
    OnClick = BasignarClick
  end
  object Button1: TButton
    Left = 160
    Top = 288
    Width = 153
    Height = 41
    Caption = 'Informaci'#243'n de Expediente'
    TabOrder = 2
    OnClick = Button1Click
  end
  object Ebuscar: TEdit
    Left = 560
    Top = 332
    Width = 121
    Height = 21
    TabOrder = 3
  end
  object CBbusqueda: TComboBox
    Left = 417
    Top = 332
    Width = 120
    Height = 21
    TabOrder = 4
  end
  object Button2: TButton
    Left = 584
    Top = 376
    Width = 75
    Height = 25
    Caption = 'Buscar'
    Default = True
    TabOrder = 5
    OnClick = Button2Click
  end
  object Bclear: TButton
    Left = 432
    Top = 376
    Width = 75
    Height = 25
    Caption = 'Limpiar'
    TabOrder = 6
    OnClick = BclearClick
  end
  object Button3: TButton
    Left = 24
    Top = 368
    Width = 97
    Height = 52
    Caption = 'Exportar Tabla'
    TabOrder = 7
    OnClick = Button3Click
  end
  object SaveD: TSaveDialog
    Left = 280
    Top = 368
  end
end
