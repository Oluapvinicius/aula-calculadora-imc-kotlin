# 📱 Calculadora de IMC - Android

Uma aplicação moderna de Calculadora de Índice de Massa Corporal (IMC) desenvolvida em **Kotlin** utilizando **Jetpack Compose**. O app permite que o usuário insira seu peso e altura para obter o diagnóstico imediato de sua composição corporal.



## ✨ Funcionalidades

- **Cálculo em tempo real:** Processa os dados inseridos e retorna o IMC com precisão.
- **Tratativa de Dados:** Converte entradas de texto para números decimais (`Double`) com segurança.
- **Interface Moderna:** Desenvolvida inteiramente com Material Design 3 e Componentes Compose.
- **Formatação Numérica:** Exibe o resultado com apenas duas casas decimais para melhor leitura.
- **Feedback Visual:** Classifica o resultado em categorias (Peso Ideal, Obesidade, etc).

## 🧮 A Lógica de Cálculo

O projeto utiliza a fórmula padrão da OMS:
$$IMC = \frac{\text{Peso}}{\text{Altura}^2}$$

### Tratativa de Erros e Conversão
Para garantir que o app não feche inesperadamente (crash), implementamos:
1. **`toDoubleOrNull()`**: Evita erros caso o usuário digite letras ou deixe campos vazios.
2. **`replace(",", ".")`**: Garante que o sistema entenda tanto a vírgula brasileira quanto o ponto americano.
3. **Validação de Zero**: O cálculo só é disparado se a altura for maior que zero, evitando erros matemáticos de divisão por zero.

## 🚀 Tecnologias Utilizadas

* [Kotlin](https://kotlinlang.org/) - Linguagem de programação oficial para Android.
* [Jetpack Compose](https://developer.android.com/jetpack/compose) - Toolkit moderno para construção de UI nativa.
* [Material 3](https://m3.material.io/) - A versão mais recente do design system do Google.

## 🛠️ Como executar o projeto

1. Clone este repositório:
   ```bash
   git clone [https://github.com/seu-usuario/calculadora-imc.git](https://github.com/seu-usuario/calculadora-imc.git)


<img src="app_screenshot.png" alt="Demonstração do Aplicativo Calculadora de IMC" width="300px">
