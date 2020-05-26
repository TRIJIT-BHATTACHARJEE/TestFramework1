$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/FeatureFiles/StoryFile.feature");
formatter.feature({
  "name": "Guess the word",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Maker starts a game",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "i launch google website",
  "keyword": "When "
});
formatter.match({
  "location": "TestingFramework.StepDef.MyStepdefs.launchGoogle()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});