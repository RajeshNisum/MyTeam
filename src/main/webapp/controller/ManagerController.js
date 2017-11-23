myApp.controller("managerController", function($scope, $location,$filter){
	

    $scope.reverse = false;
    $scope.filteredItems = [];
    $scope.groupedItems = [];
    $scope.itemsPerPage = 5;
    $scope.pagedItems = [];
    $scope.currentPage = 0;
    $scope.items =[{"employeeid":"16056","employeeName":"Rajesh Meda","firstLogin":"Mon Oct 30 09:01:30 IST 2017","lastLogout":"Mon Oct 30 16:33:28 IST 2017","totalLoginTime":"7:31","direction":"in","userid":"16056"},{"employeeid":"16056","employeeName":"Rajesh Meda","firstLogin":"2017-10-31 10:07:13.000000","lastLogout":null,"totalLoginTime":null,"direction":"in","userid":"16056"},{"employeeid":"16056","employeeName":"Rajesh Meda","firstLogin":"Tue Oct 10 09:29:02 IST 2017","lastLogout":"Tue Oct 10 18:13:17 IST 2017","totalLoginTime":"8:44","direction":"in","userid":"16056"},{"employeeid":"16056","employeeName":"Rajesh Meda","firstLogin":"Wed Oct 11 08:54:01 IST 2017","lastLogout":"Wed Oct 11 16:41:43 IST 2017","totalLoginTime":"7:47","direction":"in","userid":"16056"},{"employeeid":"16056","employeeName":"Rajesh Meda","firstLogin":"Thu Oct 12 08:59:11 IST 2017","lastLogout":"Thu Oct 12 16:55:21 IST 2017","totalLoginTime":"7:56","direction":"in","userid":"16056"},{"employeeid":"16056","employeeName":"Rajesh Meda","firstLogin":"Mon Oct 23 11:17:19 IST 2017","lastLogout":"Mon Oct 23 16:53:57 IST 2017","totalLoginTime":"5:36","direction":"in","userid":"16056"},{"employeeid":"16056","employeeName":"Rajesh Meda","firstLogin":"Fri Oct 13 09:20:02 IST 2017","lastLogout":"Fri Oct 13 16:03:34 IST 2017","totalLoginTime":"6:43","direction":"in","userid":"16056"},{"employeeid":"16056","employeeName":"Rajesh Meda","firstLogin":"Tue Oct 24 10:36:36 IST 2017","lastLogout":"Tue Oct 24 16:48:26 IST 2017","totalLoginTime":"6:11","direction":"in","userid":"16056"},{"employeeid":"16056","employeeName":"Rajesh Meda","firstLogin":"Tue Oct 03 11:01:49 IST 2017","lastLogout":"Tue Oct 03 16:36:38 IST 2017","totalLoginTime":"5:34","direction":"in","userid":"16056"},{"employeeid":"16056","employeeName":"Rajesh Meda","firstLogin":"Wed Oct 25 09:17:53 IST 2017","lastLogout":"Wed Oct 25 16:42:41 IST 2017","totalLoginTime":"7:24","direction":"in","userid":"16056"},{"employeeid":"16056","employeeName":"Rajesh Meda","firstLogin":"Wed Oct 04 08:51:40 IST 2017","lastLogout":"Wed Oct 04 16:16:24 IST 2017","totalLoginTime":"7:24","direction":"in","userid":"16056"},{"employeeid":"16056","employeeName":"Rajesh Meda","firstLogin":"Thu Oct 26 09:20:44 IST 2017","lastLogout":"Thu Oct 26 16:45:35 IST 2017","totalLoginTime":"7:24","direction":"in","userid":"16056"},{"employeeid":"16056","employeeName":"Rajesh Meda","firstLogin":"Thu Oct 05 10:02:03 IST 2017","lastLogout":"Thu Oct 05 16:20:32 IST 2017","totalLoginTime":"6:18","direction":"in","userid":"16056"},{"employeeid":"16056","employeeName":"Rajesh Meda","firstLogin":"Mon Oct 16 09:02:45 IST 2017","lastLogout":"Mon Oct 16 16:36:20 IST 2017","totalLoginTime":"7:33","direction":"in","userid":"16056"},{"employeeid":"16056","employeeName":"Rajesh Meda","firstLogin":"Fri Oct 27 09:04:02 IST 2017","lastLogout":"Fri Oct 27 18:03:09 IST 2017","totalLoginTime":"8:59","direction":"in","userid":"16056"},{"employeeid":"16056","employeeName":"Rajesh Meda","firstLogin":"Fri Oct 06 10:06:18 IST 2017","lastLogout":"Fri Oct 06 16:39:10 IST 2017","totalLoginTime":"6:32","direction":"in","userid":"16056"},{"employeeid":"16056","employeeName":"Rajesh Meda","firstLogin":"Tue Oct 17 08:57:56 IST 2017","lastLogout":"Tue Oct 17 16:04:53 IST 2017","totalLoginTime":"7:6","direction":"in","userid":"16056"},{"employeeid":"16056","employeeName":"Rajesh Meda","firstLogin":"Wed Oct 18 08:35:02 IST 2017","lastLogout":"Wed Oct 18 17:27:51 IST 2017","totalLoginTime":"8:52","direction":"in","userid":"16056"},{"employeeid":"16056","employeeName":"Rajesh Meda","firstLogin":"Mon Oct 09 09:21:46 IST 2017","lastLogout":"Mon Oct 09 16:49:41 IST 2017","totalLoginTime":"7:27","direction":"in","userid":"16056"},{"employeeid":"16142","employeeName":"Srinivas Maneti","firstLogin":"Mon Oct 30 09:48:10 IST 2017","lastLogout":"Mon Oct 30 16:19:02 IST 2017","totalLoginTime":"6:30","direction":"in","userid":"16142"},{"employeeid":"16142","employeeName":"Srinivas Maneti","firstLogin":"Fri Oct 20 08:41:24 IST 2017","lastLogout":"Fri Oct 20 13:51:51 IST 2017","totalLoginTime":"5:10","direction":"in","userid":"16142"},{"employeeid":"16142","employeeName":"Srinivas Maneti","firstLogin":"2017-10-31 09:50:15.000000","lastLogout":null,"totalLoginTime":null,"direction":"in","userid":"16142"},{"employeeid":"16142","employeeName":"Srinivas Maneti","firstLogin":"Tue Oct 10 08:45:13 IST 2017","lastLogout":"Tue Oct 10 17:32:56 IST 2017","totalLoginTime":"8:47","direction":"in","userid":"16142"},{"employeeid":"16142","employeeName":"Srinivas Maneti","firstLogin":"Wed Oct 11 08:38:56 IST 2017","lastLogout":"Wed Oct 11 16:18:09 IST 2017","totalLoginTime":"7:39","direction":"in","userid":"16142"},{"employeeid":"16142","employeeName":"Srinivas Maneti","firstLogin":"Thu Oct 12 08:29:15 IST 2017","lastLogout":"Thu Oct 12 16:43:23 IST 2017","totalLoginTime":"8:14","direction":"in","userid":"16142"},{"employeeid":"16142","employeeName":"Srinivas Maneti","firstLogin":"Fri Oct 13 08:18:03 IST 2017","lastLogout":"Fri Oct 13 16:03:44 IST 2017","totalLoginTime":"7:45","direction":"in","userid":"16142"},{"employeeid":"16142","employeeName":"Srinivas Maneti","firstLogin":"Tue Oct 24 09:14:33 IST 2017","lastLogout":"Tue Oct 24 16:46:11 IST 2017","totalLoginTime":"7:31","direction":"in","userid":"16142"},{"employeeid":"16142","employeeName":"Srinivas Maneti","firstLogin":"Wed Oct 25 09:21:04 IST 2017","lastLogout":"Wed Oct 25 17:33:17 IST 2017","totalLoginTime":"8:12","direction":"in","userid":"16142"},{"employeeid":"16142","employeeName":"Srinivas Maneti","firstLogin":"Wed Oct 04 10:52:10 IST 2017","lastLogout":"Wed Oct 04 16:20:16 IST 2017","totalLoginTime":"5:28","direction":"in","userid":"16142"},{"employeeid":"16142","employeeName":"Srinivas Maneti","firstLogin":"Thu Oct 26 09:55:35 IST 2017","lastLogout":"Thu Oct 26 14:24:32 IST 2017","totalLoginTime":"4:28","direction":"in","userid":"16142"},{"employeeid":"16142","employeeName":"Srinivas Maneti","firstLogin":"Thu Oct 05 09:08:18 IST 2017","lastLogout":"Thu Oct 05 16:13:43 IST 2017","totalLoginTime":"7:5","direction":"in","userid":"16142"},{"employeeid":"16142","employeeName":"Srinivas Maneti","firstLogin":"Mon Oct 16 09:03:50 IST 2017","lastLogout":"Mon Oct 16 16:56:09 IST 2017","totalLoginTime":"7:52","direction":"in","userid":"16142"},{"employeeid":"16142","employeeName":"Srinivas Maneti","firstLogin":"Fri Oct 27 10:07:58 IST 2017","lastLogout":"Fri Oct 27 18:03:05 IST 2017","totalLoginTime":"7:55","direction":"in","userid":"16142"},{"employeeid":"16142","employeeName":"Srinivas Maneti","firstLogin":"Fri Oct 06 09:24:19 IST 2017","lastLogout":"Fri Oct 06 16:48:55 IST 2017","totalLoginTime":"7:24","direction":"in","userid":"16142"},{"employeeid":"16142","employeeName":"Srinivas Maneti","firstLogin":"Tue Oct 17 08:50:01 IST 2017","lastLogout":"Tue Oct 17 16:54:42 IST 2017","totalLoginTime":"8:4","direction":"in","userid":"16142"},{"employeeid":"16142","employeeName":"Srinivas Maneti","firstLogin":"Wed Oct 18 08:46:50 IST 2017","lastLogout":"Wed Oct 18 17:03:59 IST 2017","totalLoginTime":"8:17","direction":"in","userid":"16142"},{"employeeid":"16142","employeeName":"Srinivas Maneti","firstLogin":"Mon Oct 09 09:47:30 IST 2017","lastLogout":"Mon Oct 09 16:20:00 IST 2017","totalLoginTime":"6:32","direction":"in","userid":"16142"}];


    var searchMatch = function (haystack, needle) {
        if (!needle) {
            return true;
        }
        return haystack.indexOf(needle) !== -1;
    };

    // init the filtered items
    $scope.search = function () {
        $scope.filteredItems = $filter('filter')($scope.items, function (item) {
            for(var attr in item) {
            	if(attr=='employeeid'){
                if (searchMatch(item[attr], $scope.query))
                    return true;
            	}
            }
            return false;
        });

        $scope.currentPage = 0;
        // now group by pages
        $scope.groupToPages();
    };
    
    // calculate page in place
    $scope.groupToPages = function () {
        $scope.pagedItems = [];
        
        for (var i = 0; i < $scope.filteredItems.length; i++) {
            if (i % $scope.itemsPerPage === 0) {
                $scope.pagedItems[Math.floor(i / $scope.itemsPerPage)] = [ $scope.filteredItems[i] ];
            } else {
                $scope.pagedItems[Math.floor(i / $scope.itemsPerPage)].push($scope.filteredItems[i]);
            }
        }
    };
    
    $scope.range = function (start, end) {
        var ret = [];
        if (!end) {
            end = start;
            start = 0;
        }
        for (var i = start; i < end; i++) {
            ret.push(i);
        }
        return ret;
    };
    
    $scope.prevPage = function () {
        if ($scope.currentPage > 0) {
            $scope.currentPage--;
        }
    };
    
    $scope.nextPage = function () {
        if ($scope.currentPage < $scope.pagedItems.length - 1) {
            $scope.currentPage++;
        }
    };
    
    $scope.setPage = function () {
        $scope.currentPage = this.n;
    };

    // functions have been describe process the data for display
    $scope.search();

    // change sorting order
    $scope.sort_by = function(newSortingOrder) {
        if ($scope.sortingOrder == newSortingOrder)
            $scope.reverse = !$scope.reverse;

        $scope.sortingOrder = newSortingOrder;

        // icon setup
        $('th i').each(function(){
            // icon reset
            $(this).removeClass().addClass('icon-sort');
        });
        if ($scope.reverse)
            $('th.'+new_sorting_order+' i').removeClass().addClass('icon-chevron-up');
        else
            $('th.'+new_sorting_order+' i').removeClass().addClass('icon-chevron-down');
    };

	
});