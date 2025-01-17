![image](https://github.com/user-attachments/assets/efb4bbae-9865-4a48-99d4-15a6b213797e)


### 🚀 **Conversor de Moedas** | **Challenge ONE** | **Alura + Oracle Next Education**

Bem-vindo ao meu primeiro conversor de moedas! Este projeto faz parte do **Challenge ONE Back-End**, desenvolvido durante minha jornada de aprendizado no programa **Oracle Next Education (ONE)** em parceria com a **Alura**. É a minha segunda postagem no GitHub, e eu estou muito animada por compartilhar essa conquista com você! 🌟

---

### 🖥️ **Sobre o Projeto**
O **Conversor de Moedas** foi projetado para facilitar a conversão entre diferentes moedas utilizando uma **API pública** para obter **taxas de câmbio** atualizadas. Aqui você verá como o **Java** pode ser usado para resolver problemas reais e como integrei uma **interface gráfica** para tornar a experiência do usuário ainda mais fluida.

#### **Funcionalidades Principais:**
- 🔗 **Consumo de API**: Conexão com uma **API pública** para **taxas de câmbio** em tempo real.
- 🛠️ **Análise da Resposta JSON**: Extração das **taxas de câmbio** diretamente do retorno da **API**.
- 🔍 **Filtro de Moedas**: Validação de **moedas** disponíveis antes de realizar a conversão.
- 💬 **Interface Amigável**: Resultados exibidos de forma clara e interativa para o usuário.

---

### 🛠️ **Configuração do Ambiente Java**

Para começar, você precisa configurar o ambiente **Java** no seu computador. Siga estas etapas:

#### **Pré-requisitos:**

1. Instale o **Java Development Kit (JDK)**. Recomenda-se a versão mais recente. Clique aqui para baixar.
2. Configure a variável de ambiente **JAVA_HOME** apontando para o diretório de instalação do **JDK**.
3. Certifique-se de que o **Java** está instalado com:

    ```bash
    java -version
    javac -version
    ```

#### **Como rodar o projeto:**

1. Clone este repositório:

    ```bash
    git clone https://github.com/seu-usuario/conversor-moedas.git
    ```

2. Compile os arquivos:

    ```bash
    javac *.java
    ```

3. Execute o programa principal:

    ```bash
    java Main
    ```

---

### 🧩 **Análise da Resposta JSON**

A **API** retorna um **JSON** com informações de **taxas de câmbio** no formato:

```json
{
  "base": "USD",
  "rates": {
    "EUR": 0.92,
    "BRL": 5.12,
    "JPY": 133.5
  }
}

```


### 🔍 **Filtro de Moedas**

O sistema valida as **moedas** de origem e destino antes de processar a conversão. Caso uma moeda inválida seja solicitada, o programa registra uma mensagem clara no **log**, evitando erros desnecessários.

---


### 💻 **Interface Gráfica e Exibição de Resultados**

A **interface gráfica** foi desenvolvida para tornar o uso mais intuitivo e interativo. Assim, o usuário pode facilmente:

- Inserir a **moeda** de origem e destino.
- Verificar a **taxa de câmbio** atualizada.
- Realizar a **conversão** com precisão.

#### Exemplo de saída:

```plaintext
A taxa de câmbio de USD para BRL é: 5.12
```


### 📁 **Estrutura do Projeto**

- **CurrencyConverter.java**: Classe principal para consumir a **API** e processar os dados.
- **CurrencyConverterGUI.java**: Classe para a interface gráfica do usuário.
- **Main.java**: Classe principal para iniciar o programa.
- **BaseGUI.java**: Classe base abstrata para padronizar e inicializar interfaces gráficas no programa.

---

### 🏆 **Minha Jornada no Challenge ONE**

Esse projeto marca um passo importante na minha trajetória como desenvolvedora. Foi desafiador trabalhar com **APIs**, **JSON** e criar uma **interface gráfica** pela primeira vez. Com o apoio do programa **Oracle Next Education** e da plataforma **Alura**, aprendi muito e me senti inspirado(a) a continuar explorando o mundo da programação.

Se você também está nessa jornada, bora compartilhar conhecimento! 🚀

---

### 💡 **Contribuições**

Sinta-se à vontade para contribuir com melhorias ou abrir **issues** com sugestões e dúvidas. Toda ajuda é bem-vinda! 💬

---

### ⚖️ **Licença**
Este projeto está sob a licença **MIT**. Veja o arquivo **LICENSE** para mais informações.

Agora é sua vez! Clone o repositório, explore o código e aprenda junto comigo. Vamos **codar**! 🎉
