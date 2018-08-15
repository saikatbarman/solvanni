'use strict';

angular.module('myApp').controller('CustomerController', ['$scope', 'CustomerService', function($scope, CustomerService) {
    var self = this;
    self.customer={customer_id:null, customer_name:'',customer_address:'',customer_internal_name:'', customer_status:''};
    self.customers=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    fetchAllCustomers();

    function fetchAllCustomers(){
        CustomerService.fetchAllCustomers()
            .then(
            function(d) {
                self.customers = d;
            },
            function(errResponse){
                console.error('Error while fetching Customers');
            }
        );
    }

    function createCustomer(customer){
        CustomerService.createCustomer(customer)
            .then(
            fetchAllCustomers,
            function(errResponse){
                console.error('Error while creating Customer');
            }
        );
    }

    function updateCustomer(customer, customer_id){
        CustomerService.updateCustomer(customer, customer_id)
            .then(
            fetchAllCustomers,
            function(errResponse){
                console.error('Error while updating Customer');
            }
        );
    }

    function deleteCustomer(customer_id){
        CustomerService.deleteCustomer(customer_id)
            .then(
            fetchAllCustomers,
            function(errResponse){
                console.error('Error while deleting Customer');
            }
        );
    }

    function submit() {
        if(self.customer.customer_id===null){
            console.log('Saving New Customer', self.customer);
            createCustomer(self.customer);
        }else{
            updateCustomer(self.customer, self.customer.customer_id);
            console.log('Customer updated with customer_id ', self.customer.customer_id);
        }
        reset();
    }

    function edit(customer_id){
        console.log('customer_id to be edited', customer_id);
        for(var i = 0; i < self.customers.length; i++){
            if(self.customers[i].customer_id === customer_id) {
                self.customer = angular.copy(self.customers[i]);
                break;
            }
        }
    }

    function remove(customer_id){
        console.log('customer_id to be deleted', customer_id);
        if(self.customer.customer_id === customer_id) {//clean form if the customer to be deleted is shown there.
            reset();
        }
        deleteCustomer(customer_id);
    }


    function reset(){
        self.customer={customer_id:null, customer_name:'',customer_address:'',customer_internal_name:'', customer_status:''};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
