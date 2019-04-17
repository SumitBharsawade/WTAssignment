var app=angular.module("MyApp",['ngRoute']);

app.config(function($routeProvider){
	$routeProvider
	.when('/',{
		templateUrl:'login.html'
	})
	.when('/welcome',{
	resolve:{
            "check":function($location,$rootScope){
                if(!$rootScope.logIn){
                    $location.path('/');
                }
            }
        },
		templateUrl:'welcome.html'
	})
	.otherwise({
		redirectTo:'/'
	});
});

app.controller('lControl',function($scope,$location,$rootScope){
	$scope.submit=function(){
		var uname=$scope.username;
		var upwd=$scope.password;
		
		if($scope.username=="admin"&&$scope.password=="123")
		{
			$rootScope.logIn=true;
			$location.path('/welcome');
		}
		else
		{
			$scope.error="User not found";
		}
	}
});

/*
var app = angular.module('MyApp', ['ngRoute']);

app.config(function($routeProvider){
    $routeProvider
    .when('/',{
        templateUrl:'login.html'
    })
    .when('/welcome',{
        resolve:{
            "check":function($location,$rootScope){
                if(!$rootScope.logIn){
                    $location.path('/');
                }
            }
        },
        templateUrl:'welcome.html'
    })
    .otherwise({
        redirectTo:'/'
    });
});

app.controller('lControl',function($scope,$location,$rootScope){
    $scope.submit = function(){
        var uname = $scope.username;
        var upwd = $scope.password;
        if($scope.username=='admin'&&$scope.password=='password'){
            $rootScope.logIn=true;
            $location.path('/welcome');
        }
        else{
            $scope.error="Username or Password is incorrect!!";
        }
    }
});

*/
