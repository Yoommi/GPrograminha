# Jogo Interativo JavaFX - CódigoVerso

Este é um jogo interativo desenvolvido em JavaFX que simula uma jornada de aprendizado em programação no "CódigoVerso" (Mundo do Senai). O jogo consiste em 23 telas, incluindo um menu inicial, seleção de personagem e nome, e uma série de desafios de quiz com lógica de progressão baseada em respostas corretas, XP e tentativas.

## Funcionalidades:

- **23 Telas Interativas**: Navegação por clique do mouse entre as telas.
- **Menu Inicial**: Ponto de partida do jogo.
- **Seleção de Personagem e Nome**: Personalize sua experiência escolhendo um nome e um personagem.
- **Quizzes de Programação**: Desafios de múltipla escolha sobre conceitos de programação (variáveis, lógica, String, Arrays, ArrayList, Funções, POO).
- **Lógica de Progressão**: Avance para a próxima tela apenas com a resposta correta.
- **Sistema de XP**: Ganhe pontos de experiência ao acertar as perguntas.
- **Sistema de Tentativas**: Cada quiz tem um número limitado de tentativas. Errar uma pergunta consome uma tentativa. Se as tentativas acabarem, o jogo reinicia.
- **Telas de Interação**: Pausas temáticas entre os desafios para simular o ambiente do Senai.

## Como Executar o Projeto:

### Pré-requisitos:

- Java Development Kit (JDK) 11 ou superior
- Apache Maven

### Passos para Executar:

1.  **Navegue até o diretório do projeto:**
    ```bash
    cd /home/ubuntu/GP/GP/javafx_multi_screen_with_quiz/javafx_multi_screen
    ```

2.  **Compile e execute o projeto usando Maven:**
    ```bash
    mvn clean javafx:run
    ```

    *   **Observação**: Se você estiver usando uma IDE como IntelliJ IDEA, pode abrir o projeto e executar a classe `MainApp.java` diretamente.

### Estrutura do Projeto:

-   `src/main/java/com/example/gp/MainApp.java`: Classe principal da aplicação JavaFX.
-   `src/main/java/com/example/gp/GameController.java`: Controlador principal que gerencia a lógica do jogo, as telas, as perguntas, o XP e as tentativas.
-   `src/main/resources/com/example/gp/fxml/GameView.fxml`: Arquivo FXML que define a interface de usuário para todas as telas do jogo.
-   `src/main/resources/com/example/gp/images/`: Diretório contendo as imagens utilizadas no jogo.

Divirta-se aprendendo programação no CódigoVerso!

