var app = angular.module("myApp",[]);

app.controller("myController",function($scope)
{
	$scope.group = [{name:"Johnny Depp",java:4,webApps:1,ajs:4,bstrp:1,junit:3,mockito:0,jenkins:1,pcf:1},
	                {name:"Kiara Delepine",java:9,webApps:1,ajs:4,bstrp:1,junit:3,mockito:1,jenkins:1,pcf:1},
	                {name:"Denzel Washington",java:4,webApps:1,ajs:4,bstrp:1,junit:3,mockito:7,jenkins:1,pcf:1},
	                {name:"Micahel Jackson",java:4,webApps:1,ajs:4,bstrp:1,junit:3,mockito:1,jenkins:1,pcf:1},
	                {name:"DeVonte Freeman",java:4,webApps:1,ajs:4,bstrp:1,junit:null,mockito:1,jenkins:1,pcf:1},
	                {name:"Whitney Houston",java:4,webApps:1,ajs:4,bstrp:-2,junit:3,mockito:1,jenkins:1,pcf:1}];
	
	sortByKey($scope.group,'name');
	
	function sortByKey(arr,key)
	{
		return arr.sort(function(a,b)
		{
			var x = a[key];
			var y = b[key];
			
			return ((x < y) ? -1: ((x > y) ? 1:0));
		});
	}
});