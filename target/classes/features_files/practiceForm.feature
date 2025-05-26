# language: en

@formScenarios
Feature: Je souhaite remplir la Student Registration Form
  En tant que utilisateur je souhaite remplir la Student Registration Form
  
Background: L utilisateur accède à la page Book Store Application
    Given je me rends sur la page DemoQA
    When je clique sur le bouton BookStore
    And La page Book Store Application s affiche 
    And L utilisateur est sur la page Book Store Application 
    When je clique sur le bouton Forms
    And je clique sur le button pratciceForm
    Then Un formulaire d inscription est affiché à l écran
    
    
    @RemplirLeFormulaireStudentRegistrationForm
    Scenario: L utilisateur remplit correctement le formulaire d inscription étudiant
    When Il saisit le nom dans le champ First Name
    And Il saisit le prenom dans le champ Last Name
    And Il saisit l email  dans le champ Email
    And Il sélectionne son genre 
    And Il saisit le mobile
    And Il sélectionne le mois de naissance 
    And Il sélectionne l annéé de naissance
    And Il sélectionne le jour de naissance
    And Il saisit la section dans le champ Subjects
    And Il coche ses hobbies 
    And Il ajoute une image au champ Picture
    And Il saisit son adresse dans le champ Current Address
    And Il sélectionne son état
    And Il sélectionne sa ville
    And Il clique sur le bouton submit
    Then un récapitulatif des données s affiche, validant la soumission