/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

/**
 *
 * @author R16
 */
public interface TabelOlahData {
    public abstract void add(Object o);
    public abstract void viewAll();
    public abstract void remove(Object o);
    public abstract void loadData();
    public abstract void emptyTemp();
}
