package com.e2etests.automation.step_definitions;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.e2etests.automation.page_object.PracticeFormPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Validations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PracticeFormStepDefinition {

	private PracticeFormPage practiceFormPage; // contient les webElements
	private SeleniumUtils seleniumUtils;
	private Validations validations;
	private ConfigFileReader configFileReader;

	public PracticeFormStepDefinition() {
		this.practiceFormPage = new PracticeFormPage();
		this.seleniumUtils = new SeleniumUtils();
		this.configFileReader = new ConfigFileReader();
		this.validations = new Validations();
	}

	@Given("je me rends sur la page DemoQA")
	public void jeMeRendsSurLaPageDemoQA() {
		seleniumUtils.get(configFileReader.getProperties("demoqa.url"));

	}

	@When("je clique sur le bouton BookStore")
	public void jeCliqueSurLeBoutonBookStore() {
		seleniumUtils.click(practiceFormPage.bookStoreApplication);

	}

	@When("La page Book Store Application s affiche")
	public void laPageBookStoreApplicationSAffiche() throws InterruptedException {
		Long mediumWait = seleniumUtils.getWait("MediumWait");
		Thread.sleep(mediumWait);
		validations.assertTrueBoolean(practiceFormPage.leftPannel);
	}

	@When("L utilisateur est sur la page Book Store Application")
	public void lUtilisateurEstSurLaPageBookStoreApplication() {
		validations.assertTrueBoolean(practiceFormPage.Toolsqa);

	}

	@When("je clique sur le bouton Forms")
	public void jeCliqueSurLeBoutonForms() {
		seleniumUtils.click(practiceFormPage.Forms);

	}

	@When("je clique sur le button pratciceForm")
	public void jeCliqueSurLeButtonPratciceForm() throws InterruptedException {
		Long mediumWait = seleniumUtils.getWait("MediumWait");
		Thread.sleep(mediumWait);
		seleniumUtils.click(practiceFormPage.practiceFormSpan);
	}

	@Then("Un formulaire d inscription est affiché à l écran")
	public void unFormulaireDInscriptionEstAffichéÀLÉcran() throws InterruptedException {
		Long mediumWait = seleniumUtils.getWait("MediumWait");
		Thread.sleep(mediumWait);
		validations.assertTrueBoolean(practiceFormPage.practiceFormTitle);

	}

	@When("Il saisit le nom dans le champ First Name")
	public void ilSaisitLeNomDansLeChampFirstName() {
		seleniumUtils.writeText(practiceFormPage.firstname, configFileReader.getProperties("demoqa.username"));
	}

	@When("Il saisit le prenom dans le champ Last Name")
	public void ilSaisitLePrenomDansLeChampLastName() {
		seleniumUtils.writeText(practiceFormPage.lastname, configFileReader.getProperties("demoqa.lastname"));
	}

	@When("Il saisit l email  dans le champ Email")
	public void ilSaisitLEmailDansLeChampEmail() {
		seleniumUtils.writeText(practiceFormPage.userEmail, configFileReader.getProperties("demoqa.email"));

	}

	@When("Il sélectionne son genre")
	public void ilSélectionneSonGenre() throws InterruptedException {
		Long mediumWait = seleniumUtils.getWait("MediumWait");
		Thread.sleep(mediumWait);
		List<WebElement> genderOptions = Arrays.asList(practiceFormPage.OptionMale, practiceFormPage.OptionFemale,
				practiceFormPage.OptionOther);
		seleniumUtils.clickRadioByLabelText("Male", genderOptions);
	}

	/**
	 * la prochaine fois
	 */
	@When("Il saisit le mobile")
	public void ilSaisitLeMobile() {
		seleniumUtils.writeText(practiceFormPage.userNumber, configFileReader.getProperties("demoqa.mobile"));
	}

	@When("Il clique sur le calendrier")
	public void ilCliqueSurLeCalendrier() throws InterruptedException {
		seleniumUtils.click(practiceFormPage.dateOfBirthInput);
		Long mediumWait = seleniumUtils.getWait("MediumWait");
		Thread.sleep(mediumWait);
	}

	@When("Il sélectionne le mois de naissance")
	public void ilSélectionneLeMoisDeNaissance() throws InterruptedException {

		seleniumUtils.selectMonthByVisibleText(practiceFormPage.mois, "March");
		
	}

	@When("Il sélectionne l annéé de naissance")
	public void ilSélectionneLAnnééDeNaissance() {

	}

	@When("Il sélectionne le jour de naissance")
	public void ilSélectionneLeJourDeNaissance() {

	}

	@When("Il saisit la section dans le champ Subjects")
	public void ilSaisitLaSectionDansLeChampSubjects() {

	}

	@When("Il coche ses hobbies")
	public void ilCocheSesHobbies() {

	}

	@When("Il ajoute une image au champ Picture")
	public void ilAjouteUneImageAuChampPicture() {

	}

	@When("Il saisit son adresse dans le champ Current Address")
	public void ilSaisitSonAdresseDansLeChampCurrentAddress() {

	}

	@When("Il sélectionne son état")
	public void ilSélectionneSonÉtat() {

	}

	@When("Il sélectionne sa ville")
	public void ilSélectionneSaVille() {

	}

	@When("Il clique sur le bouton submit")
	public void ilCliqueSurLeBoutonSubmit() {

	}

	@Then("un récapitulatif des données s affiche, validant la soumission")
	public void unRécapitulatifDesDonnéesSAfficheValidantLaSoumission() {

	}

}
