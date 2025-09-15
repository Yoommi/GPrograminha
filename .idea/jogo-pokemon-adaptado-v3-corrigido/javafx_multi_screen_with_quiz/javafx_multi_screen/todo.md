## Tarefas para o Projeto JavaFX Multi-Tela

### Fase 1: Configurar estrutura do projeto JavaFX
- [x] Criar diretório do projeto (já feito)
- [x] Criar estrutura básica de diretórios para `src`, `main`, `java`, `resources`, `fxml`
- [x] Criar arquivo `pom.xml` para Maven (ou `build.gradle` para Gradle) com as dependências do JavaFX

### Fase 2: Criar classe principal e controlador de navegação
- [x] Criar a classe `MainApp.java` que estende `Application`
- [x] Criar um controlador de navegação para gerenciar a troca de telas

### Fase 3: Desenvolver múltiplas telas com arquivos FXML
- [x] Criar `HomeView.fxml`
- [x] Criar `Screen1View.fxml`
- [x] Criar `Screen2View.fxml`

### Fase 4: Implementar controladores para cada tela
- [x] Criar `HomeController.java`
- [x] Criar `Screen1Controller.java`
- [x] Criar `Screen2Controller.java`

### Fase 5: Criar sistema de menu e navegação
- [x] Adicionar um `MenuBar` ao `RootLayout.fxml`
- [x] Implementar a lógica de navegação no `RootLayoutController` e `MainApp`

### Fase 6: Adicionar imagens ao projeto
- [x] Criar diretório para imagens
- [x] Copiar imagens para o diretório do projeto

### Fase 7: Integrar imagens nas telas FXML
- [x] Modificar `HomeView.fxml` para incluir `ImageView`
- [x] Modificar `Screen1View.fxml` para incluir `ImageView`
- [x] Modificar `Screen2View.fxml` para incluir `ImageView`

### Fase 8: Desenvolver a tela de Quiz (FXML)
- [x] Criar `QuizView.fxml`

### Fase 9: Implementar o controlador do Quiz e a lógica do jogo
- [x] Criar `QuizController.java` com a lógica do quiz
- [x] Copiar imagens dos Pokémon para o projeto

### Fase 10: Integrar a tela de Quiz no menu de navegação
- [x] Adicionar opção "Quiz Pokémon" ao menu em `RootLayout.fxml`
- [x] Adicionar método `showQuizView()` em `MainApp.java`
- [x] Adicionar método `showQuiz()` em `RootLayoutController.java`

### Fase 11: Testar aplicação e entregar código completo
- [ ] Compilar a aplicação (execução direta não é possível no ambiente sandbox)
- [ ] Testar a troca de telas via menu, incluindo a tela do Quiz
- [ ] Empacotar o projeto e fornecer instruções de execução

