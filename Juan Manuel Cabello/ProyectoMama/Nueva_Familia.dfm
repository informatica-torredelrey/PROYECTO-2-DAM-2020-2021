object Fnueva: TFnueva
  Left = 0
  Top = 0
  Caption = 'Nueva Familia'
  ClientHeight = 389
  ClientWidth = 601
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  OnActivate = FormActivate
  PixelsPerInch = 96
  TextHeight = 13
  object L1: TLabel
    Left = 40
    Top = 24
    Width = 109
    Height = 13
    Caption = 'Numero de Expediente'
  end
  object Eexpediente: TEdit
    Left = 155
    Top = 21
    Width = 121
    Height = 21
    TabOrder = 0
  end
  object Panel: TPanel
    Left = 21
    Top = 64
    Width = 532
    Height = 281
    TabOrder = 2
    object Label1: TLabel
      Left = 48
      Top = 38
      Width = 18
      Height = 13
      Caption = 'DNI'
    end
    object Label2: TLabel
      Left = 48
      Top = 73
      Width = 37
      Height = 13
      Caption = 'Nombre'
    end
    object Label3: TLabel
      Left = 48
      Top = 113
      Width = 42
      Height = 13
      Caption = 'Apellidos'
    end
    object Label4: TLabel
      Left = 48
      Top = 154
      Width = 24
      Height = 13
      Caption = 'Edad'
    end
    object l2: TLabel
      Left = 272
      Top = 38
      Width = 119
      Height = 13
      Caption = 'Miembros de convivencia'
    end
    object Label5: TLabel
      Left = 272
      Top = 73
      Width = 96
      Height = 13
      Caption = 'Numero de Menores'
    end
    object Label6: TLabel
      Left = 272
      Top = 113
      Width = 72
      Height = 13
      Caption = 'Unidad Familiar'
    end
    object Label7: TLabel
      Left = 272
      Top = 197
      Width = 24
      Height = 13
      Caption = 'Zona'
    end
    object Label8: TLabel
      Left = 272
      Top = 237
      Width = 32
      Height = 13
      Caption = 'Equipo'
    end
    object Enombre: TEdit
      Left = 107
      Top = 62
      Width = 121
      Height = 21
      TabOrder = 1
      OnEnter = marcarTexto
      OnExit = desmarcarText
    end
    object Eapellido: TEdit
      Left = 107
      Top = 110
      Width = 121
      Height = 21
      TabOrder = 2
      OnEnter = marcarTexto
      OnExit = desmarcarText
    end
    object Eedad: TEdit
      Left = 107
      Top = 151
      Width = 121
      Height = 21
      TabOrder = 3
      OnEnter = marcarTexto
      OnExit = desmarcarText
    end
    object Edni: TEdit
      Left = 107
      Top = 35
      Width = 121
      Height = 21
      TabOrder = 0
      OnEnter = marcarTexto
      OnExit = desmarcarText
    end
    object Spinmiembos: TSpinEdit
      Left = 416
      Top = 35
      Width = 57
      Height = 22
      MaxValue = 50
      MinValue = 0
      TabOrder = 5
      Value = 0
    end
    object SpinMenores: TSpinEdit
      Left = 416
      Top = 70
      Width = 57
      Height = 22
      MaxValue = 50
      MinValue = 0
      TabOrder = 6
      Value = 0
    end
    object SpinFamilia: TSpinEdit
      Left = 416
      Top = 110
      Width = 57
      Height = 22
      MaxValue = 50
      MinValue = 0
      TabOrder = 7
      Value = 0
    end
    object ChDiscapacidad: TCheckBox
      Left = 409
      Top = 153
      Width = 97
      Height = 17
      Caption = 'Discapacitados'
      TabOrder = 8
      WordWrap = True
    end
    object Chmayor65: TCheckBox
      Left = 272
      Top = 153
      Width = 97
      Height = 17
      Caption = 'Mayores de 65'
      TabOrder = 9
    end
    object RGsexo: TRadioGroup
      Left = 107
      Top = 194
      Width = 81
      Height = 63
      Caption = 'Sexo'
      Items.Strings = (
        'Hombre'
        'Mujer')
      TabOrder = 4
    end
    object CBzona: TComboBox
      Left = 365
      Top = 194
      Width = 141
      Height = 21
      TabOrder = 10
    end
    object CBequipo: TComboBox
      Left = 365
      Top = 232
      Width = 141
      Height = 21
      TabOrder = 11
    end
  end
  object Bnuevoexp: TButton
    Left = 304
    Top = 19
    Width = 105
    Height = 25
    Caption = 'Nuevo Expediente'
    Default = True
    TabOrder = 1
    OnClick = EexpedienteExit
  end
  object Bguardar: TButton
    Left = 430
    Top = 351
    Width = 99
    Height = 30
    Caption = 'Guardar'
    TabOrder = 3
    OnClick = BguardarClick
  end
  object Bcancelar: TButton
    Left = 21
    Top = 351
    Width = 99
    Height = 30
    Caption = 'Cancelar'
    TabOrder = 4
    OnClick = BcancelarClick
  end
end
