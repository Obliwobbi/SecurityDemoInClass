package dk.ek.rest;

import dk.ek.exceptions.ApiException;
import dk.ek.persistence.Department;
import dk.ek.persistence.DepartmentDAO;
import dk.ek.persistence.Employee;
import dk.ek.persistence.EmployeeDAO;
import dk.ek.persistence.HibernateConfig;
import io.javalin.apibuilder.EndpointGroup;
import io.javalin.http.Context;
import jakarta.persistence.EntityNotFoundException;

import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

public class Routes {

    private final EmployeeDAO employeeDAO = new EmployeeDAO(HibernateConfig.getEntityManagerFactory());
    private final DepartmentDAO departmentDAO = new DepartmentDAO(HibernateConfig.getEntityManagerFactory());

    public EndpointGroup getRouteResource(String resourceName) {
        return switch (resourceName.toLowerCase()) {
            case "msg" -> () -> path("msg", () -> {
                        get("hello", ctx -> ctx.result("Hello World!"));
                        post("echo", ctx -> ctx.result(ctx.body()));
            });
//            case "employee", "person" -> () -> path("employees", () -> {
//                get(this::getAllEmployees);
//                get("{id}", this::getEmployeeById);
//                post(this::createEmployee);
//                put("{id}", this::updateEmployee);
//                delete("{id}", this::deleteEmployee);
//            });
//            case "department" -> () -> path("departments", () -> {
//                get(this::getAllDepartments);
//                get("{id}", this::getDepartmentById);
//                post(this::createDepartment);
//                put("{id}", this::updateDepartment);
//                delete("{id}", this::deleteDepartment);
//            });
            default -> throw new IllegalArgumentException("Unknown resource name: " + resourceName);
    };

//    private void getAllEmployees(Context ctx) {
//        ctx.json(employeeDAO.get());
//    }
//
//    private void getEmployeeById(Context ctx) {
//        try {
//            ctx.json(employeeDAO.getByID(getPathId(ctx)));
//        } catch (EntityNotFoundException e) {
//            throw new ApiException(404, e.getMessage());
//        }
//    }
//
//    private void createEmployee(Context ctx) {
//        Employee employee = ctx.bodyAsClass(Employee.class);
//        ctx.status(201).json(employeeDAO.create(employee));
//    }
//
//    private void updateEmployee(Context ctx) {
//        Employee employee = ctx.bodyAsClass(Employee.class);
//        employee.setId(getPathId(ctx));
//        try {
//            ctx.json(employeeDAO.updateWithCheck(employee));
//        } catch (EntityNotFoundException e) {
//            throw new ApiException(404, e.getMessage());
//        }
//    }
//
//    private void deleteEmployee(Context ctx) {
//        Employee employee = new Employee();
//        employee.setId(getPathId(ctx));
//        try {
//            Long deletedId = employeeDAO.delete(employee);
//            ctx.json(new DeleteResponse(deletedId));
//        } catch (EntityNotFoundException e) {
//            throw new ApiException(404, e.getMessage());
//        }
//    }
//
//    private void getAllDepartments(Context ctx) {
//        ctx.json(departmentDAO.get());
//    }
//
//    private void getDepartmentById(Context ctx) {
//        try {
//            ctx.json(departmentDAO.getByID(getPathId(ctx)));
//        } catch (EntityNotFoundException e) {
//            throw new ApiException(404, e.getMessage());
//        }
//    }
//
//    private void createDepartment(Context ctx) {
//        Department department = ctx.bodyAsClass(Department.class);
//        ctx.status(201).json(departmentDAO.create(department));
//    }
//
//    private void updateDepartment(Context ctx) {
//        Department department = ctx.bodyAsClass(Department.class);
//        department.setId(getPathId(ctx));
//        try {
//            ctx.json(departmentDAO.update(department));
//        } catch (EntityNotFoundException e) {
//            throw new ApiException(404, e.getMessage());
//        }
//    }
//
//    private void deleteDepartment(Context ctx) {
//        Department department = new Department();
//        department.setId(getPathId(ctx));
//        try {
//            Long deletedId = departmentDAO.delete(department);
//            ctx.json(new DeleteResponse(deletedId));
//        } catch (EntityNotFoundException e) {
//            throw new ApiException(404, e.getMessage());
//        }
//    }
//
//    private Long getPathId(Context ctx) {
//        try {
//            return Long.valueOf(ctx.pathParam("id"));
//        } catch (NumberFormatException e) {
//            throw new ApiException(400, "Path parameter 'id' must be a number");
//        }
//    }
//
//    private record DeleteResponse(Long id) {
//    }
}
