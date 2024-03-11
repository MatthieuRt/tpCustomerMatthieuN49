/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpcustomermatthieun49.jsf;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mg.itu.tpcustomermatthieun49.entity.Customer;
import mg.itu.tpcustomermatthieun49.service.CustomerManager;
import org.primefaces.model.FilterMeta;

/**
 * Backing bean de la page customerList.xhtml.
 *
 * @author Matthieu R
 */
@Named(value = "customerBean")
@ViewScoped
public class CustomerBean implements Serializable {

    private List<Customer> customerList;
    private List<FilterMeta> filterBy;
    private List<Customer> filteredCustomers;

    @Inject
    private CustomerManager customerManager;

    public CustomerBean() {
    }

    @PostConstruct
    public void init() {
        filterBy = new ArrayList<>();
    }

    /**
     * Retourne la liste des clients pour affichage dans une DataTable.
     */
    public List<Customer> getCustomers() {
        if (customerList == null) {
            customerList = customerManager.getAllCustomers();
        }
        return customerList;
    }

    /**
     * Retourne la liste des clients filtrés pour affichage dans une DataTable.
     */
    public List<Customer> getFilteredCustomers() {
        return filteredCustomers;
    }

    public List<FilterMeta> getFilterBy() {
        return filterBy;
    }

    public void setFilteredCustomers(List<Customer> filteredCustomers) {
        this.filteredCustomers = filteredCustomers;
    }
}
