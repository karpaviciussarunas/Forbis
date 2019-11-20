/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.fotoas.forbis.DAO;

import java.util.List;
import lt.fotoas.forbis.model.ProjectTexts;

/**
 *
 * @author Sars
 */
public interface TextDao {
    public List<ProjectTexts> getAllTexts();
    public void addText(ProjectTexts text);
    
}
