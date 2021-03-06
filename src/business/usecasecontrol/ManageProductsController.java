
package business.usecasecontrol;

import java.util.List;
import java.util.logging.Logger;

import middleware.exceptions.DatabaseException;
import business.exceptions.BackendException;
import business.externalinterfaces.Catalog;
import business.externalinterfaces.Product;
import business.externalinterfaces.ProductSubsystem;
import business.productsubsystem.ProductSubsystemFacade;


public enum ManageProductsController   {
    INSTANCE;
    private static final Logger LOG = 
    	Logger.getLogger(ManageProductsController.class.getName());
    
    public List<Product> getProductsList(String catalog) throws BackendException {
    	ProductSubsystem pss = new ProductSubsystemFacade();    
    	//LOG.warning("ManageProductsController method getProductsList has not been implemented");
    	//return null;
    	Catalog cat = pss.getCatalogFromName(catalog);
    	return pss.getProductList(cat);
    }
    
    public List<Catalog> getCatalogList() throws BackendException {
    	ProductSubsystem pss = new ProductSubsystemFacade();
    	return pss.getCatalogList();
    }
    public int saveNewCatalog(String catName) throws BackendException {
    	ProductSubsystem pss = new ProductSubsystemFacade(); 
    	return pss.saveNewCatalog(catName);
    }
    
    public void saveNewProduct(Product product) throws BackendException{
    	ProductSubsystem pss = new ProductSubsystemFacade();
    	pss.saveNewProduct(product);
    }
    
    public void deleteCatalog(Catalog catalog) throws BackendException {
    	ProductSubsystem pss = new ProductSubsystemFacade();
    	pss.deleteCatalog(catalog);
    }
    
    public void deleteProduct(Product product) throws BackendException{
    	//implement
    	ProductSubsystem pss = new ProductSubsystemFacade();
    	pss.deleteProduct(product);
    }
    
    
}
