object Modificar: TModificar
  Left = 0
  Top = 0
  Caption = 'Modificar'
  ClientHeight = 500
  ClientWidth = 600
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
  object Lexpediente: TLabel
    Left = 19
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
  object Panel: TPanel
    Left = 19
    Top = 45
    Width = 582
    Height = 369
    TabOrder = 0
    object Label1: TLabel
      Left = 40
      Top = 25
      Width = 18
      Height = 13
      Caption = 'DNI'
    end
    object Label2: TLabel
      Left = 40
      Top = 60
      Width = 37
      Height = 13
      Caption = 'Nombre'
    end
    object Label3: TLabel
      Left = 40
      Top = 100
      Width = 42
      Height = 13
      Caption = 'Apellidos'
    end
    object Label4: TLabel
      Left = 40
      Top = 141
      Width = 24
      Height = 13
      Caption = 'Edad'
    end
    object l2: TLabel
      Left = 289
      Top = 32
      Width = 119
      Height = 13
      Caption = 'Miembros de convivencia'
    end
    object Label5: TLabel
      Left = 289
      Top = 60
      Width = 96
      Height = 13
      Caption = 'Numero de Menores'
    end
    object Label6: TLabel
      Left = 289
      Top = 100
      Width = 72
      Height = 13
      Caption = 'Unidad Familiar'
    end
    object Label7: TLabel
      Left = 296
      Top = 208
      Width = 24
      Height = 13
      Caption = 'Zona'
    end
    object Label8: TLabel
      Left = 296
      Top = 248
      Width = 32
      Height = 13
      Caption = 'Equipo'
    end
    object Enombre: TEdit
      Left = 99
      Top = 57
      Width = 121
      Height = 21
      TabOrder = 1
    end
    object Eapellido: TEdit
      Left = 99
      Top = 97
      Width = 121
      Height = 21
      TabOrder = 2
    end
    object Eedad: TEdit
      Left = 99
      Top = 138
      Width = 121
      Height = 21
      TabOrder = 3
    end
    object Edni: TEdit
      Left = 99
      Top = 22
      Width = 121
      Height = 21
      TabOrder = 0
    end
    object Spinmiembos: TSpinEdit
      Left = 433
      Top = 29
      Width = 57
      Height = 22
      MaxValue = 50
      MinValue = 0
      TabOrder = 5
      Value = 0
    end
    object SpinMenores: TSpinEdit
      Left = 433
      Top = 57
      Width = 57
      Height = 22
      MaxValue = 50
      MinValue = 0
      TabOrder = 6
      Value = 0
    end
    object SpinFamilia: TSpinEdit
      Left = 433
      Top = 97
      Width = 57
      Height = 22
      MaxValue = 50
      MinValue = 0
      TabOrder = 7
      Value = 0
    end
    object ChDiscapacidad: TCheckBox
      Left = 433
      Top = 164
      Width = 97
      Height = 17
      Caption = 'Discapacitados'
      TabOrder = 8
      WordWrap = True
    end
    object Chmayor65: TCheckBox
      Left = 296
      Top = 164
      Width = 97
      Height = 17
      Caption = 'Mayores de 65'
      TabOrder = 9
    end
    object RGsexo: TRadioGroup
      Left = 99
      Top = 181
      Width = 81
      Height = 63
      Caption = 'Sexo'
      Items.Strings = (
        'Hombre'
        'Mujer')
      TabOrder = 4
    end
    object CBzona: TComboBox
      Left = 389
      Top = 205
      Width = 141
      Height = 21
      TabOrder = 10
    end
    object CBequipo: TComboBox
      Left = 389
      Top = 243
      Width = 141
      Height = 21
      TabOrder = 11
    end
  end
  object Button1: TButton
    Left = 500
    Top = 420
    Width = 75
    Height = 33
    Caption = 'Modificar'
    TabOrder = 1
    OnClick = Button1Click
  end
  object Button2: TButton
    Left = 51
    Top = 420
    Width = 75
    Height = 33
    Caption = 'Cancelar'
    TabOrder = 2
    OnClick = Button2Click
  end
end
