package com.example.gp;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameController {

    @FXML
    private Label titleLabel;
    @FXML
    private TextArea questionTextArea; // Alterado para TextArea
    @FXML
    private ImageView mainImageView;
    @FXML
    private Button optionAButton;
    @FXML
    private Button optionBButton;
    @FXML
    private Button optionCButton;
    @FXML
    private Button optionDButton; // Adicionado botão D
    @FXML
    private Button nextButton;
    @FXML
    private TextField nameTextField;
    @FXML
    private VBox characterSelectionBox;
    @FXML
    private ImageView characterImageView;
    @FXML
    private Label resultLabel;
    @FXML
    private Label xpLabel;
    @FXML
    private Label attemptsLabel;
    @FXML
    private Button exitButton; // Botão de sair

    private MainApp mainApp;
    private int currentScreen = 1;
    private String playerName = "";
    private String selectedCharacter = "";
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int currentXP = 0;
    private int remainingAttempts = 0;
    private boolean hasTesteLogico = false;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        initializeGame();
    }

    private void initializeGame() {
        setupQuestions();
        loadScreen(currentScreen);
    }

    private void setupQuestions() {
        questions = new ArrayList<>();

        // Tela 1: Menu Inicial
        questions.add(new Question("Bem-vindo ao CódigoVerso!", "/com/example/gp/images/pokeball.png", null, null, 0, 0, 0));

        // Tela 2: Introdução
        questions.add(new Question("Olá, [nome do jogador]!\nVocê foi misteriosamente transportado para o CódigoVerso, um mundo onde lógica, programação e criatividade são suas armas.\nPara voltar ao mundo real, você precisará completar os módulos (fases), dominando a arte da programação!", "/com/example/gp/images/senai.png", null, null, 0, 0, 0));

        // Tela 3: Desafio Módulo 1 – Variáveis
        questions.add(new Question("Módulo 1 – Variáveis\nPergunta: Qual é a forma correta de criar uma variável?\n\nA) int idade = \"25\";\nB) String nome == \"Lucas\";\nC) double altura = 1.75;\nD) boolean ativo = true;", "/com/example/gp/images/classroom.png",
                Arrays.asList("A) int idade = \"25\";", "B) String nome == \"Lucas\";", "C) double altura = 1.75;", "D) boolean ativo = true;"), "D) boolean ativo = true;", 2, 15, 0));

        // Tela 4: Desafio Módulo 2 – Condições (if/else)
        questions.add(new Question("Módulo 2 – Condições (if/else)\nPergunta: Qual será a saída?\n\n```java\nint a = 10;\nint b = 20;\nif (a > 5 && b < 30) {\nSystem.out.println(\"Condição verdadeira\");\n} else {\nSystem.out.println(\"Condição falsa\");\n}\n```\n\nA) Condição verdadeira\nB) Condição falsa\nC) 10\nD) 20", "/com/example/gp/images/logic_test.png",
                Arrays.asList("A) Condição verdadeira", "B) Condição falsa", "C) 10", "D) 20"), "A) Condição verdadeira", 2, 15, 0));

        // Tela 5: Desafio Módulo 3 – Strings
        questions.add(new Question("Módulo 3 – Strings\nPergunta: Qual será a saída?\n\n```java\nString palavra = \"Programar\";\nSystem.out.println(palavra.length());\n```\n\nA) 7\nB) 8\nC) 9\nD) 10", "/com/example/gp/images/string_methods.png",
                Arrays.asList("A) 7", "B) 8", "C) 9", "D) 10"), "C) 9", 2, 20, 1));

        // Tela 6: Desafio Módulo 4 – Arrays
        questions.add(new Question("Módulo 4 – Arrays\nPergunta: Qual será a saída?\n\n```java\nint[] numeros = {10, 20, 30, 40};\nSystem.out.println(numeros[1]);\n```\n\nA) 10\nB) 20\nC) 30\nD) 40", "/com/example/gp/images/arrays.png",
                Arrays.asList("A) 10", "B) 20", "C) 30", "D) 40"), "B) 20", 3, 20, 0));

        // Tela 7: Desafio Módulo 5 – ArrayList
        questions.add(new Question("Módulo 5 – ArrayList\nPergunta: Como acessar o primeiro nome da lista alunos?\n\nA) alunos.get(1);\nB) alunos.get(0);\nC) alunos[0];\nD) alunos.first();", "/com/example/gp/images/arraylist.png",
                Arrays.asList("A) alunos.get(1);", "B) alunos.get(0);", "C) alunos[0];", "D) alunos.first();"), "B) alunos.get(0);", 1, 30, 0));

        // Tela 8: Desafio Módulo 6 – Funções
        questions.add(new Question("Módulo 6 – Funções\nPergunta: Qual assinatura correta da função somar que recebe dois inteiros e retorna a soma?\n\nA) public void somar(int a, int b)\nB) int somar(a, b)\nC) public int somar(int a, int b)\nD) void somar(int a, b)", "/com/example/gp/images/functions.png",
                Arrays.asList("A) public void somar(int a, int b)", "B) int somar(a, b)", "C) public int somar(int a, int b)", "D) void somar(int a, b)"), "C) public int somar(int a, int b)", 1, 50, 0));

        // Tela 9: Desafio Módulo 7 – POO
        questions.add(new Question("Módulo 7 – POO\nPergunta: Na classe Aluno, você tem o atributo nota. Qual assinatura correta para o método arredondarNota que retorna a nota arredondada?\n\nA) int arredondarNota(double nota)\nB) public void arredondarNota()\nC) public boolean arredondarNota()\nD) public int arredondarNota()", "/com/example/gp/images/poo.png",
                Arrays.asList("A) int arredondarNota(double nota)", "B) public void arredondarNota()", "C) public boolean arredondarNota()", "D) public int arredondarNota()"), "D) public int arredondarNota()", 1, 100, 0));

        // Telas de Interação (Extras)
        questions.add(new Question("Pausa para açaí! 🍧\nRefeitório com açaí nas mesinhas.", "/com/example/gp/images/refeitorio_acai.png", null, null, 0, 0, 0));
        questions.add(new Question("Pausa para Pingue Pongue! 🏓\nDois aluninhos jogando pingue pongue.", "/com/example/gp/images/pingue_pongue.png", null, null, 0, 0, 0));
        questions.add(new Question("Pausa para o Intervalo! 🍞\nSala toda, no refeitório, comendo salgado nas mesinhas.", "/com/example/gp/images/refeitorio_salgado.png", null, null, 0, 0, 0));
        questions.add(new Question("Pausa para Xadrez Gigante! ♟️\nDois aluninhos jogando xadrez do tamanho deles.", "/com/example/gp/images/xadrez_gigante.png", null, null, 0, 0, 0));
        questions.add(new Question("Pausa para pegar água! 🚶\nAluninho passeando no corredor com uma garrafinha de água.", "/com/example/gp/images/corredor_agua.png", null, null, 0, 0, 0));
    }

    public void loadScreen(int screenNumber) {
        currentScreen = screenNumber;
        hideAllElements();
        updateExitButtonVisibility();

        if (screenNumber == 1) {
            showMenuScreen();
        } else if (screenNumber == 2) {
            showNameInputScreen();
        } else if (screenNumber >= 3 && screenNumber <= questions.size() + 1) {
            showQuizScreen(screenNumber - 2);
        } else {
            showCompletionScreen();
        }
    }

    private void hideAllElements() {
        if (titleLabel != null) titleLabel.setVisible(false);
        if (xpLabel != null) xpLabel.setVisible(false);
        if (attemptsLabel != null) attemptsLabel.setVisible(false);
        if (questionTextArea != null) questionTextArea.setVisible(false);
        if (mainImageView != null) mainImageView.setVisible(false);
        if (optionAButton != null) optionAButton.setVisible(false);
        if (optionBButton != null) optionBButton.setVisible(false);
        if (optionCButton != null) optionCButton.setVisible(false);
        if (optionDButton != null) optionDButton.setVisible(false);
        if (nextButton != null) nextButton.setVisible(false);
        if (nameTextField != null) nameTextField.setVisible(false);
        if (characterSelectionBox != null) characterSelectionBox.setVisible(false);
        if (characterImageView != null) characterImageView.setVisible(false);
        if (resultLabel != null) resultLabel.setVisible(false);
    }

    private void updateExitButtonVisibility() {
        if (exitButton != null) {
            exitButton.setVisible(currentScreen != 1); // Esconde o botão de sair na tela inicial
        }
    }

    private void showMenuScreen() {
        titleLabel.setVisible(true);
        titleLabel.setText("Bem-vindo ao CódigoVerso!");

        mainImageView.setVisible(true);
        mainImageView.setImage(new Image(getClass().getResourceAsStream("/com/example/gp/images/pokeball.png")));

        nextButton.setVisible(true);
        nextButton.setText("Iniciar Jogo");
    }

    private void showNameInputScreen() {
        titleLabel.setVisible(true);
        titleLabel.setText("Introdução");

        questionTextArea.setVisible(true);
        questionTextArea.setText("Olá, [nome do jogador]!\nVocê foi misteriosamente transportado para o CódigoVerso, um mundo onde lógica, programação e criatividade são suas armas.\nPara voltar ao mundo real, você precisará completar os módulos (fases), dominando a arte da programação!");
        questionTextArea.setEditable(false);

        nameTextField.setVisible(true);
        nameTextField.setPromptText("Digite seu nome");

        nextButton.setVisible(true);
        nextButton.setText("Continuar");
    }

    private void showQuizScreen(int questionIndex) {
        if (questionIndex < questions.size()) {
            Question question = questions.get(questionIndex);
            currentQuestionIndex = questionIndex;

            titleLabel.setVisible(true);
            titleLabel.setText("Tela " + (currentScreen));

            xpLabel.setVisible(true);
            xpLabel.setText("XP: " + currentXP);

            attemptsLabel.setVisible(true);
            attemptsLabel.setText("Tentativas: " + remainingAttempts);

            questionTextArea.setVisible(true);
            questionTextArea.setText(question.getQuestionText().replace("[nome do jogador]", playerName));
            questionTextArea.setEditable(false);

            mainImageView.setVisible(true);
            if (question.getImagePath() != null) {
                try {
                    mainImageView.setImage(new Image(getClass().getResourceAsStream(question.getImagePath())));
                } catch (Exception e) {
                    mainImageView.setImage(new Image(getClass().getResourceAsStream("/com/example/gp/images/pokeball.png")));
                }
            } else {
                mainImageView.setImage(null);
            }

            if (question.getOptions() != null && !question.getOptions().isEmpty()) {
                List<String> options = new ArrayList<>(question.getOptions());
                Collections.shuffle(options);

                optionAButton.setVisible(true);
                optionAButton.setText(options.get(0));
                optionBButton.setVisible(true);
                optionBButton.setText(options.get(1));
                optionCButton.setVisible(true);
                optionCButton.setText(options.get(2));
                optionDButton.setVisible(true);
                optionDButton.setText(options.get(3));

                resultLabel.setVisible(true);
                resultLabel.setText("");
                setButtonsEnabled(true);
                nextButton.setVisible(false);

                if (question.getMaxAttempts() > 0) {
                    remainingAttempts = question.getMaxAttempts();
                    if (hasTesteLogico && currentQuestionIndex == 5) { // Módulo 4 - Arrays (índice 5 na lista de questions)
                        remainingAttempts = 3; // Aplica o bônus do Teste Lógico
                        hasTesteLogico = false; // Consome o item
                    }
                    attemptsLabel.setText("Tentativas: " + remainingAttempts);
                }

            } else {
                optionAButton.setVisible(false);
                optionBButton.setVisible(false);
                optionCButton.setVisible(false);
                optionDButton.setVisible(false);
                resultLabel.setVisible(false);
                setButtonsEnabled(false);

                nextButton.setVisible(true);
                nextButton.setText("Continuar");
            }
        } else {
            showCompletionScreen();
        }
    }

    private void showCompletionScreen() {
        titleLabel.setVisible(true);
        titleLabel.setText("Parabéns, " + playerName + "!");

        questionTextArea.setVisible(true);
        questionTextArea.setText("Você completou todas as telas do jogo!\n\nRecompensas:\n- " + currentXP + " XP\n- Certificado de garoto de programa profissional");
        questionTextArea.setEditable(false);

        mainImageView.setVisible(true);
        mainImageView.setImage(new Image(getClass().getResourceAsStream("/com/example/gp/images/pokeball.png")));

        nextButton.setVisible(true);
        nextButton.setText("Jogar Novamente");
    }

    @FXML
    private void handleNext() {
        if (currentScreen == 1) {
            loadScreen(2);
        } else if (currentScreen == 2) {
            if (nameTextField.getText().trim().isEmpty()) {
                resultLabel.setVisible(true);
                resultLabel.setText("Por favor, digite seu nome!");
                resultLabel.setStyle("-fx-text-fill: red;");
                return;
            }
            playerName = nameTextField.getText().trim();
            loadScreen(3);
        } else if (currentScreen >= 3 && currentScreen < questions.size() + 2) {
            // A lógica de Game Over agora é tratada dentro de checkAnswer
            loadScreen(currentScreen + 1);
            setButtonsEnabled(true);
            nextButton.setVisible(false);
        } else if (currentScreen == questions.size() + 2) { // Última tela (Completion Screen)
            restartGame();
        }
    }

    private void showGameOverScreen() {
        titleLabel.setVisible(true);
        titleLabel.setText("Game Over!");

        questionTextArea.setVisible(true);
        questionTextArea.setText("Infelizmente suas tentativas excederam, comece do zero.");
        questionTextArea.setEditable(false);

        mainImageView.setVisible(true);
        mainImageView.setImage(new Image(getClass().getResourceAsStream("/com/example/gp/images/pokeball.png")));

        nextButton.setVisible(true);
        nextButton.setText("Recomeçar");
    }

    private void restartGame() {
        currentScreen = 1;
        playerName = "";
        selectedCharacter = "";
        currentQuestionIndex = 0;
        currentXP = 0;
        remainingAttempts = 0;
        hasTesteLogico = false;
        setupQuestions(); // Re-setup questions to reset any state if needed
        loadScreen(1);
    }

    @FXML
    private void handleOptionA() {
        checkAnswer(optionAButton.getText());
    }

    @FXML
    private void handleOptionB() {
        checkAnswer(optionBButton.getText());
    }

    @FXML
    private void handleOptionC() {
        checkAnswer(optionCButton.getText());
    }

    @FXML
    private void handleOptionD() {
        checkAnswer(optionDButton.getText());
    }

    private void checkAnswer(String selectedAnswer) {
        Question currentQuestion = questions.get(currentQuestionIndex);

        if (currentQuestion.getCorrectAnswer() == null) {
            nextButton.setVisible(true);
            nextButton.setText("Continuar");
            setButtonsEnabled(false);
            return;
        }

        if (currentQuestion.getCorrectAnswer().equals(selectedAnswer)) {
            String rewardText = "Parabéns você acertou! Vamos para o próximo desafio...\n\nRecompensas:\n- " + currentQuestion.getXpReward() + " XP";

            if (currentQuestionIndex == 2) { // Módulo 1 - Variáveis
                rewardText += "\n- Você recebeu um Teste Lógico";
                hasTesteLogico = true;
            } else if (currentQuestionIndex == 3) { // Módulo 2 - Condições
                rewardText += "\n- E um carinho do Professor Leo =)";
            } else if (currentQuestionIndex == 4) { // Módulo 3 - Strings
                rewardText += "\n- E um Café do Professor Leo =) (+1 tentativa no próximo desafio)";
                remainingAttempts += currentQuestion.getBonusAttempts(); // Adiciona tentativa bônus
            } else if (currentQuestionIndex == 5) { // Módulo 4 - Arrays
                rewardText += "\n- E um Açaí com granola e paçoca";
            } else if (currentQuestionIndex == 6) { // Módulo 5 - ArrayList
                rewardText += "\n- E um Ping Pong com JohnMen";
            } else if (currentQuestionIndex == 7) { // Módulo 6 - Funções
                rewardText += "\n- E um CFC de graça";
            } else if (currentQuestionIndex == 8) { // Módulo 7 - POO
                rewardText += "\n- Certificado de Garoto de Programa Profissional 🎓";
            }

            resultLabel.setText(rewardText);
            resultLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
            currentXP += currentQuestion.getXpReward();

            nextButton.setVisible(true);
            nextButton.setText("Próximo");
            setButtonsEnabled(false);
        } else {
            remainingAttempts--;
            if (remainingAttempts > 0) {
                resultLabel.setText("Parabéns você errou! Só resta apenas " + remainingAttempts + " tentativa(s).");
                resultLabel.setStyle("-fx-text-fill: orange; -fx-font-weight: bold;");
                // Não avança, espera nova tentativa
            } else {
                resultLabel.setText("Parabéns você errou! Infelizmente suas tentativas excederam, comece do zero.\nA resposta correta era: " + currentQuestion.getCorrectAnswer());
                resultLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
                setButtonsEnabled(false);
                nextButton.setVisible(true);
                nextButton.setText("Recomeçar");
                showGameOverScreen(); // Chama a tela de Game Over para reiniciar o jogo
            }
        }
    }

    private void setButtonsEnabled(boolean enabled) {
        optionAButton.setDisable(!enabled);
        optionBButton.setDisable(!enabled);
        optionCButton.setDisable(!enabled);
        optionDButton.setDisable(!enabled);
    }

    @FXML
    private void handleExit() {
        Platform.exit();
    }

    private static class Question {
        private String questionText;
        private String imagePath;
        private List<String> options;
        private String correctAnswer;
        private int maxAttempts;
        private int xpReward;
        private int bonusAttempts;

        public Question(String questionText, String imagePath, List<String> options, String correctAnswer, int maxAttempts, int xpReward, int bonusAttempts) {
            this.questionText = questionText;
            this.imagePath = imagePath;
            this.options = options;
            this.correctAnswer = correctAnswer;
            this.maxAttempts = maxAttempts;
            this.xpReward = xpReward;
            this.bonusAttempts = bonusAttempts;
        }

        public String getQuestionText() {
            return questionText;
        }

        public String getImagePath() {
            return imagePath;
        }

        public List<String> getOptions() {
            return options;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }

        public int getMaxAttempts() {
            return maxAttempts;
        }

        public int getXpReward() {
            return xpReward;
        }

        public int getBonusAttempts() {
            return bonusAttempts;
        }
    }
}


