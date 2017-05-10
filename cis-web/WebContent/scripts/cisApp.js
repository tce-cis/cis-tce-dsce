var cisApp = angular.module('cisApp', [ "ngRoute" ]);

cisApp.config(function($routeProvider) {
	$routeProvider.when("/faculty", {
		templateUrl : "views/faculty_details.html",
		controller : "FacultyController"
	}).when("/events", {
		templateUrl : "views/events.html"
	}).when("/about", {
		templateUrl : "views/about.html"
	}).when("/companies", {
		templateUrl : "views/companies.html"
	}).when("/faculty_profile", {
		templateUrl : "views/faculty_profile.html"
	}).when("/semester_result", {
		templateUrl : "views/semester_result.html"
	}).when("/about", {
		templateUrl : "views/about.html"
	}).when("/student_details", {
		templateUrl : "views/student_details.html"
	}).when("/program_outcomes", {
		templateUrl : "views/program_outcomes.html"
	}).when("/pso", {
		templateUrl : "views/pso.html"
	}).when("/research_completed", {
		templateUrl : "views/research_completed.html"
	}).when("/research_on_going", {
		templateUrl : "views/research_on_going.html"
	}).when("/feedback", {
		templateUrl : "views/feedback.html"
	}).when("/sem_result_analysis", {
		templateUrl : "views/sem_result_analysis.html"
	}).when("/placement_analysis", {
		templateUrl : "views/placement_analysis.html"
	}).otherwise({
		templateUrl : "views/about.html"
	});
});

cisApp.controller('HomeController', function($scope, $http) {

	$scope.getFacultyDetails = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/cis-web/FacultyServlet'
		}).success(function(data, status, headers, config) {
			$scope.person = data;
		}).error(function(data, status, headers, config) {
		});

	};
});

cisApp.controller('FacultyController', function($scope, $http) {

	$http({
		method : 'GET',
		url : 'http://localhost:8080/cis-web/FacultyServlet'
	}).success(function(data, status, headers, config) {
		$scope.faculties = data;
	}).error(function(data, status, headers, config) {
	});


});
