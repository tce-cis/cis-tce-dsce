var cisApp = angular.module('cisApp', [ "ngRoute" ]);

cisApp.config([ '$locationProvider', function($locationProvider) {
	$locationProvider.hashPrefix('');
} ]);

cisApp.config(function($routeProvider) {
	$routeProvider.when("/faculty", {
		templateUrl : "views/faculty_details.html",
		controller : "FacultyController"
	}).when("/events", {
		templateUrl : "views/events.html"
	}).when("/about", {
		templateUrl : "views/about.html"
	}).when("/companies", {
		templateUrl : "views/companies.html",
		controller : "CompanyController"
	}).when("/faculty_profile", {
		templateUrl : "views/faculty_profile.html",
		controller : "FacultyController"
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
		templateUrl : "views/feedback.html",
		controller : "FeedbackController"
	}).when("/sem_result_analysis", {
		templateUrl : "views/sem_result_analysis.html"
	}).when("/subjects", {
		templateUrl : "views/subjects.html",
		controller : "SubjectController"
	}).when("/placement_analysis", {
		templateUrl : "views/placement_analysis.html"
	}).when("/syllabus", {
		templateUrl : "views/syllabus.html"
	}).otherwise({
		templateUrl : "views/about.html"
	});
});

cisApp.controller('HomeController', function($scope, $http) {
});

cisApp.controller('SubjectController', function($scope, $http) {
	$http({
		method : 'GET',
		url : '/cis-web/subjects'
	}).then(function(data, status, headers, config) {
		$scope.subjects = data.data;
	}, function(data, status, headers, config) {
	});

});
cisApp.controller('CompanyController', function($scope, $http) {
	$http({
		method : 'GET',
		url : '/cis-web/companies'
	}).then(function(data, status, headers, config) {
		$scope.companies = data.data;
	}, function(data, status, headers, config) {
	});

});

cisApp.controller('FacultyController', function($scope, $http) {

	$http({
		method : 'GET',
		url : '/cis-web/faculty'
	}).then(
			function(data, status, headers, config) {
				var facultyList = data.data;
				for (var i = 0; i < facultyList.length; i++) {
					var facultyName = facultyList[i].name;
					facultyList[i].imageName = facultyName.trim().replace(/ /g, '_').toLowerCase()
							+ ".jpg";
				}
				$scope.faculties = facultyList;
				$scope.faculty = $scope.faculties[14];
				$scope.topic = $scope.faculty.name;
			}, function(data, status, headers, config) {
			});

	$http({
		method : 'GET',
		url : 'http://localhost:8080/cis-web/publication'
	}).then(function(data, status, headers, config) {
		$scope.publications = data.data;
	}, function(data, status, headers, config) {
	});

	/*
	 * $scope.getFacultyById = function() { $http({ method : 'GET', url :
	 * 'cis-web/faculty_details?facultyId=' + $scope.facultyId
	 * }).then(function(data, status, headers, config) { $scope.faculty =
	 * data.data; }, function(data, status, headers, config) { }); }
	 */
});
cisApp
		.controller(
				'FeedbackController',
				function($scope, $http) {

					$scope.feedbackInputs = [ '5-Excellent', '4-Very Good',
							'3-Good', '2-Satisfactory', '1-Poor' ];
					$scope.feedback = {
						'teaching' : $scope.feedbackInputs[0],
						'timeUtilization' : $scope.feedbackInputs[0],
						'contentDelivery' : $scope.feedbackInputs[0],
						'regularity' : $scope.feedbackInputs[0],
						'practicalAspect' : $scope.feedbackInputs[0],
						'doubtsClarification' : $scope.feedbackInputs[0],
						'evaluation' : $scope.feedbackInputs[0],
						'availability' : $scope.feedbackInputs[0],
						'syllabusCoverage' : $scope.feedbackInputs[0],
						'dressCode' : $scope.feedbackInputs[0]
					};

					$scope.submitFeedback = function() {

						$http
								.post('/cis-web/feedback',
										JSON.stringify($scope.feedback))
								.then(
										function(data, status, headers, config) {
											$scope.message = "Your feedback has been submitted successfully. Thank you";
										},
										function(data, status, headers, config) {
										});

						$http({
							method : 'POST',
							url : '/cis-web/feedback',
							data : {
								'feedback' : $scope.feedback
							},
							headers : {
								'Content-Type' : 'application/json'
							}
						})
								.then(
										function(response, status, headers,
												config) {
											$scope.message = "Your feedback has been submitted successfully. Thank you";
										},
										function(response, status, headers,
												config) {
										});
					}
				});