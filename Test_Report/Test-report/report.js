$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "MakeMyTrip Feature",
  "description": "",
  "id": "makemytrip-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "MakeMyTrip login Scenario",
  "description": "",
  "id": "makemytrip-feature;makemytrip-login-scenario",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@A"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user enters username and password",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user is on MakeMyTrip Home Page",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user capture screen shot after successfull login",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "user is able close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginFunctionality.user_enters_username_and_password()"
});
formatter.result({
  "duration": 34046284000,
  "status": "passed"
});
formatter.match({
  "location": "LoginFunctionality.user_is_on_MakeMyTrip_Home_Page()"
});
formatter.result({
  "duration": 95101782700,
  "status": "passed"
});
formatter.match({
  "location": "LoginFunctionality.user_capture_screen_shot_after_successfull_login()"
});
formatter.result({
  "duration": 2469305700,
  "status": "passed"
});
formatter.match({
  "location": "LoginFunctionality.user_is_able_close_the_browser()"
});
formatter.result({
  "duration": 4347014100,
  "status": "passed"
});
});