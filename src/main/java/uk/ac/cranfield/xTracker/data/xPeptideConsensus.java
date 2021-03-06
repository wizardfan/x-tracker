package uk.ac.cranfield.xTracker.data;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Jun Fan@cranfield
 */
public class xPeptideConsensus extends QuantitationLevel{
    private String seq;
    private ArrayList<xPeptide> peptides;
    public xPeptideConsensus(String seq){
        this.seq = seq;
        peptides = new ArrayList<xPeptide>();
    }
    /**
     * Get all peptides
     * @return 
     */
    public ArrayList<xPeptide> getPeptides() {
        return peptides;
    }
    /**
     * find the corresponding xPeptide object for the given modifications, if no match, return null
     * @param mods modifications
     * @return 
     */
    public xPeptide getPeptide(HashSet<xModification> mods){
        for(xPeptide pep:peptides){
            HashSet<xModification> existing = pep.getModifications();
            if(mods.size()!=existing.size()) continue;//if modification list size not matching
            boolean allMatch = true;
            for(xModification mod:mods){
                if(!existing.contains(mod)){
                   allMatch = false;
                   break;
                }
            }
            if(allMatch) return pep;
        }
        return null;
    }
    /**
     * Add a peptide with a new modification pattern to the list
     * @param peptide 
     */
    public void addPeptide(xPeptide peptide){
        peptides.add(peptide);
    }
    /**
     * Get the peptide sequence
     * @return 
     */
    public String getSeq() {
        return seq;
    }

    @Override
    public int getCount(){
        return peptides.size();
    }
}
