# language: en
@loginScenarios
Feature: Je souhaite tester la connexion de la page Swag Labs
  En tant que utilisateur je souhaite tester la connexion de la page Swag Labs
  
Background: 
   Given je suis sur la page de connexion Swag Labs


  @login_casPassant
  Scenario: Connexion reussie avec des informations d identification correctes
    When je saisie le username valide "standard_user"
    And je saisie le password valide "secret_sauce"
    And je clique sur le boutton login
    Then Je me redirige vers la page home "Products"

  @login_casNonPassant_usernameInvalide
  Scenario: Connexion echouee avec username invalide
    When je saisie le username invalide "fatima"
    And je saisie le password valide "secret_sauce"
    And je clique sur le boutton login
    Then Je me redirige vers un message d erreur "Epic sadface: Username and password do not match any user in this service"

  @login_casNonPassant_passwordInvalide
  Scenario: Connexion echouee avec password invalide
    When je saisie le username valide "standard_user"
    And je saisie le password invalide "fatima"
    And je clique sur le boutton login
    Then Je me redirige vers un message d erreur "Epic sadface: Username and password do not match any user in this service"

  @login_casNonPassant_passwordVide
  Scenario: Connexion echouee avec password vide
    When je saisie le username valide "standard_user"
    And je laisse le password vide ""
    And je clique sur le boutton login
    Then Je me redirige vers un message d erreur "Epic sadface: Password is required"

  @login_casNonPassant_usernamedVide
  Scenario: Connexion echouee avec username vide
    When je laisse le username vide ""
    And je saisie le password valide "secret_sauce"
    And je clique sur le boutton login
    Then Je me redirige vers un message d erreur "Epic sadface: Username is required"

  @login_casNonPassant_usernamedAndPasswordVides
  Scenario: Connexion echouee avec username et password vide
    When je laisse le username vide ""
    And je laisse le password vide ""
    And je clique sur le boutton login
    Then Je me redirige vers un message d erreur "Epic sadface: Username is required"
    
  @casNonPassantOptimized_Login
  Scenario: Je souhaite tester la page de connexion abec un cas non passant 
    Given Je me connecte à l application web Swag Labs avec des identifiants incorrects
    Then Je me redirige vers un message d erreur "Epic sadface: Username and password do not match any user in this service"

