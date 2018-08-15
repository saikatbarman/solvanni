<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Solvanni Test</title>  
    <style>
      .username.ng-valid {
          background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }

      .customer_internal_name.ng-valid {
          background-color: lightgreen;
      }
      .customer_internal_name.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }
      
      .customer_status.ng-valid {
          background-color: lightgreen;
      }
      .customer_status.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }
      
      .customer_internal_name.ng-valid {
          background-color: lightgreen;
      }
      .customer_internal_name.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }

    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  <body data-ng-app="myApp" class="ng-cloak">
      <div class="generic-container" data-ng-controller="CustomerController as cc">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Add Customer Form</span></div>
              <div class="formcontainer">
                  <form data-ng-submit="cc.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" data-ng-model="cc.customer.customer_id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Name</label>
                              <div class="col-md-7">
                                  <input type="text" data-ng-model="cc.customer.customer_name" name="customer_name" class="username form-control input-sm" placeholder="Enter Customer Name" required data-ng-minlength="3"/>
                                  <div class="has-error" data-ng-show="myForm.$dirty">
                                      <span data-ng-show="myForm.customer_name.$error.required">This is a required field</span>
                                      <span data-ng-show="myForm.customer_name.$error.minlength">Minimum length required is 3</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Address</label>
                              <div class="col-md-7">
                                  <input type="text" data-ng-model="cc.customer.customer_address" name="customer_address" class="customer_address form-control input-sm" placeholder="Enter Customer Address." required/>
                                  <div class="has-error" data-ng-show="myForm.$dirty">
                                      <span data-ng-show="myForm.customer_address.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Internal Name</label>
                              <div class="col-md-7">
                                  <input type="text" data-ng-model="cc.customer.customer_internal_name" name="customer_internal_name" class="customer_internal_name form-control input-sm" placeholder="Enter Customer Internal Name" required/>
                                  <div class="has-error" data-ng-show="myForm.$dirty">
                                      <span data-ng-show="myForm.customer_internal_name.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>

					<div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Status</label>
                              <div class="col-md-7">
                                  <input type="text" data-ng-model="cc.customer.customer_status" name="customer_status" class="customer_status form-control input-sm" placeholder="Enter Status" required/>
                                  <div class="has-error" data-ng-show="myForm.$dirty">
                                      <span data-ng-show="myForm.customer_status.$error.required">This is a required field</span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!cc.customer.customer_id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" data-ng-disabled="myForm.$invalid">
                              <button type="button" data-ng-click="cc.reset()" class="btn btn-warning btn-sm" data-ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Users </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Name</th>
                              <th>Address</th>
                              <th>Internal Name</th>
                              <th>Status</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr data-ng-repeat="u in cc.customers">
                              <td><span data-ng-bind="u.customer_id"></span></td>
                              <td><span data-ng-bind="u.customer_name"></span></td>
                              <td><span data-ng-bind="u.customer_address"></span></td>
                              <td><span data-ng-bind="u.customer_internal_name"></span></td>
                              <td><span data-ng-bind="u.customer_status"></span></td>
                              <td>
                              <button type="button" data-ng-click="cc.edit(u.customer_id)" class="btn btn-success custom-width">Edit</button>  <button type="button" data-ng-click="cc.remove(u.customer_id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/customer_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/customer_controller.js' />"></script>
  </body>
</html>