package uk.ac.cranfield.xTracker.plugins.quantitation;

import java.util.*;

public class LcMsAreasSimpson implements quantPlugin {

    public void start(String paramFile) {
    }
//    
//    public xQuant tmp(xPeaks inputData, String paramFile) {
//        //Let's retrieve how many files have been processed
//        int size = inputData.getSize();
//        int i = -1;
//        xCorrespondences myFileCorr = null;
//        //The output structure
//        xQuant ret = new xQuant();
//
//        //Let's process the peaks belonging to every raw data file
//        for (i = 0; i < size; i++) {
//            myFileCorr = inputData.getElemAt(i);
//            //The raw data file name
//            String fileName = myFileCorr.getFileName();
//            //Let's get the set of unique labels we want to quantitate on.
//            String[] labels = myFileCorr.getUniqueLabelsOfLcMsCorr();
//            int labSize = labels.length;
//            int corrSize = myFileCorr.getPeptideCorrespondenceDataSize();
//
//            xQuantData myQuantData = new xQuantData(fileName, labSize);
//            myQuantData.setAllLabels(labels);
//
//            //Let's process any correspondence
//            for (int ii = 0; ii < corrSize; ii++) {
//                xCorrespondenceData myCdata = myFileCorr.getPeptideCorrespondenceDataElemtAt(ii);
//                //Let's retrieve the proteinId and peptide sequence
//                String protId = myCdata.getProteinId();
//                String pepSeq = myCdata.getPeptideSeq();
//                //Vectors for modifications associated to the peak of this peptide.
//                Vector<String> modNames = new Vector<String>();
//                Vector<Integer> modPos = new Vector<Integer>();
//
//                int lcMsSize = myCdata.getLcMsCorrSize();
//                int indx = -1;
//                Vector rts[] = new Vector[labSize];
//                Vector ics[] = new Vector[labSize];
//                //Let's loop now through all lcMs peaks stored for this couple proteinId, peptideSeq.
//                for (int jj = 0; jj < lcMsSize; jj++) {
//                    xLcMsCorr myLcMsCorr = myCdata.getLcMsCorrElemAt(jj);
//                    String lbl = myLcMsCorr.getLabel();
//                    boolean searching = true;
//                    for (int k = 0; k < labSize && searching; k++) {
//                        if (labels[k].equals(lbl)) {
//                            searching = false;
//                            indx = k;
//                        }
//
//                    }
//                    if (!searching) {
//                        if (rts[indx] == null) {
//                            //Let's create the rt vector and add the rt value of the peak to the vector corresponding to lbl experimental condition
//                            rts[indx] = new Vector<Float>();
//                            rts[indx].addElement(Float.valueOf(myLcMsCorr.getRT()));
//                            //Let's create the intensity vector and add the intensity value of the peak to the vector corresponding to lbl experimental condition
//                            ics[indx] = new Vector<Float>();
//                            ics[indx].addElement(Float.valueOf(myLcMsCorr.getIntensity()));
//

//**from sumIntensities.java    
//                        } else {
//                            //Let's add the rt value of the peak to the vector corresponding to lbl experimental condition
//                            rts[indx].addElement(Float.valueOf(myLcMsCorr.getRT()));
//                            //Let's add the intensity value of the peak to the vector corresponding to lbl experimental condition
//                            ics[indx].addElement(Float.valueOf(myLcMsCorr.getIntensity()));
//                        }
//**//finish

//**from computeLcMsAreas.java
//                        } else {
//                            //We have to keep the vectors ordered by increasing RT!
//                            float rtVal = myLcMsCorr.getRT();
//                            int my_index = Collections.binarySearch(rts[indx], rtVal);  //findIndex(rts[indx],rtVal);
//                            if (my_index < 0) {
//                                my_index = 0 - my_index - 1;
//                            }
//
//                            //Let's add the rt value of the peak to the vector corresponding to lbl experimental condition
//                            rts[indx].add(my_index, Float.valueOf(myLcMsCorr.getRT()));
//                            //Let's add the intensity value of the peak to the vector corresponding to lbl experimental condition
//                            ics[indx].add(my_index, Float.valueOf(myLcMsCorr.getIntensity()));
//                        }
//**//finish
    
    
    //                        } else {
//                            //We have to keep the vectors ordered by increasing RT!
//                            float rtVal = myLcMsCorr.getRT();
//                            int my_index = findIndex(rts[indx], rtVal);
//                            //Let's add the rt value of the peak to the vector corresponding to lbl experimental condition
//                            rts[indx].add(my_index, Float.valueOf(myLcMsCorr.getRT()));
//                            //Let's add the intensity value of the peak to the vector corresponding to lbl experimental condition
//                            ics[indx].add(my_index, Float.valueOf(myLcMsCorr.getIntensity()));
//                        }
//                    } else {
//                        System.out.println("ERROR (computeLcMsAreaSimpson): Label (" + lbl + ") not found!");
//                        System.exit(1);
//                    }
//
//                    //Adding modifications (if any)
//                    for (int modCnt = 0; modCnt < myLcMsCorr.getModificationSize(); modCnt++) {
//                        int pos = myLcMsCorr.getModPositionAtIndex(modCnt);
//                        String modNM = myLcMsCorr.getModificationNameAtIndex(modCnt);
//                        int posWhere = modPos.indexOf(pos);
//                        int modWhere = modNames.indexOf(modNM);
//                        if (posWhere == -1 || modWhere == -1 || posWhere != modWhere) {
//                            modPos.addElement(pos);
//                            modNames.addElement(modNM);
//                        }
//                    }
//                }
//                //Let's create a quantities data structure
//                xQuantities quantElem = new xQuantities(protId, pepSeq, labSize);
//                for (int kk = 0; kk < labSize; kk++) {
//                    float qty = this.computeArea(rts[kk], ics[kk]);
//                    //Let's add the quantity in the right place
//                    quantElem.addQuantity(kk, qty);
//                }
//                //Let's add modifications to the quantities data structure.
//                for (int kk = 0; kk < modPos.size(); kk++) {
//                    quantElem.addModification(modNames.elementAt(kk), modPos.elementAt(kk));
//                }
//
//                //Let's add it to the xQuantData structure
//                myQuantData.addQuantitativeDataElem(quantElem);
//            }
//            //Let's add all the quantitative information from the raw data file to the xQuant structure
//            ret.addQuantificationDataElem(myQuantData);
//        }
//        return ret;
//    }
//
//    /**    
//     * Computes the area of the peak Ion chromatogram specified. NOTE THAT it assumes 
//     * the vectors ordered by Retention Time ascendingly.
//     * @param IC the vector of Intensities.
//     * @param RT the vector of retention times.
//     * @return the area of the peak.
//     */
//    public float computeArea(Vector<Float> RT, Vector<Float> IC) {
//
//        float ret = 0;
//        float tmp_val = 0;
//        int size = RT.size();
//        int remainder = size % 3;
//        int i = 0;
//        int starti = 0;
//        int endi = size - 1;
//        float x1 = 0; //RT values
//        float x2 = 0;
//        float x3 = 0;
//        float y1 = 0; //Intensity values
//        float y2 = 0;
//        float y3 = 0;
//        float h = 0; //the common mz step (it's the average of the two steps)
//        for (int j = 0; j < RT.size(); j++) {
//            System.out.println(j + ") RT[" + RT.elementAt(j) + "]=" + IC.elementAt(j));
//        }
//
//        if (size > 1) {
//            switch (remainder) {
//                case 1: {
//                    //The number of peaks cannot be divided by three, the first and last two peaks will be integrated with
//                    //trapezoid rule.
//                    tmp_val = (IC.elementAt(0) + IC.elementAt(1)) * (RT.elementAt(1) - RT.elementAt(0)) / 2;
//                    ret += tmp_val;
//                    starti = 2;
//                    tmp_val = (IC.elementAt(size - 2) + IC.elementAt(size - 1)) * (RT.elementAt(size - 1) - RT.elementAt(size - 2)) / 2;
//                    ret += tmp_val;
//                    endi = size - 2;
//
//                }
//                case 2: {
//                    //The number of peaks cannot be divided by three, the first two peaks will be integrated with
//                    //trapezoid rule.
//                    tmp_val = (IC.elementAt(0) + IC.elementAt(1)) * (RT.elementAt(1) - RT.elementAt(0)) / 2;
//                    ret += tmp_val;
//                    starti = 2;
//
//                }
//            }
//        }
//        for (i = starti; i < endi; i = i + 3) {
//            x1 = RT.elementAt(i);
//            x2 = RT.elementAt(i + 1);
//            x3 = RT.elementAt(i + 2);
//            y1 = IC.elementAt(i);
//            y2 = IC.elementAt(i + 1);
//            y3 = IC.elementAt(i + 2);
//
//            h = (x3 - x1) / 2;
//
//            // System.out.println("x:" + x1 + " " + x2 + " " + x3 + " y:" + y1 + " " + y2 + " " + y3 + " h:" + h);
//
//            tmp_val = h * (y1 / 3 + (4 * y2) / 3 + y3 / 3);
//            ret += tmp_val;
//        }
//
//        return ret;
//    }
//
    

//from computeLcMsAreas.java
//    private final static String description = "This plugin reads in LC/MS peak correspondences and computes the area in the time domain with trapezoids rule.";
//    /**
//     * Computes the area of the peak Ion chromatogram specified. NOTE THAT it assumes
//     * the vectors ordered by Retention Time ascendingly.
//     * @param IC the vector of Intensities.
//     * @param RT the vector of retention times.
//     * @return the area of the peak.
//     */
//    public float computeArea(Vector<Float> RT, Vector<Float> IC) {
//        float ret = 0;
//        float tmp_val = 0;
//        int size = RT.size();
//
//        Vector<Float> tmpRT = new Vector<Float>();
//        Vector<Float> tmpIC = new Vector<Float>();
//        System.out.println("RT size:" + RT.size() + " IC size:" + IC.size());
//        for (int j = 0; j < size; j++) {
//            // System.out.println(j+ ") RT[" + RT.elementAt(j) + "]=" + IC.elementAt(j));
//            float tmpRTval = RT.elementAt(j);
//            float tmpICval = IC.elementAt(j);
//            int position = tmpRT.indexOf(Float.valueOf(tmpRTval));
//            if (position == -1) {
//                tmpRT.addElement(tmpRTval);
//                tmpIC.addElement(tmpICval);
//            } else {
//                tmpIC.setElementAt(tmpIC.elementAt(position) + tmpICval, position);
//            }
//        }
//        size = tmpRT.size();
//        for (int i = 0; i < size - 1; i++) {
//            tmp_val = (tmpIC.elementAt(i) + tmpIC.elementAt(i + 1)) * (tmpRT.elementAt(i + 1) - tmpRT.elementAt(i)) / 2;
//            ret += tmp_val;
//        }
//
//        //OLD CODE
//   /*
//        for(int i=0;i<size-1;i++){
//        tmp_val=(IC.elementAt(i)+IC.elementAt(i+1))*(RT.elementAt(i+1)-RT.elementAt(i))/2;
//        ret+=tmp_val;
//        }
//        
//         */
//        return ret;
//    }


    /** from sumIntensities.java all other codes are identical
     * Computes the area of the peak Ion chromatogram specified. 
     * @param IC the vector of Intensities.
     * @param RT the vector of retention times.
     * @return the area of the peak.
     */
    public float computeQuantity(Vector<Float> RT, Vector<Float> IC) {

        float ret = 0;
        int i = 0;
        int size = IC.size();

        float oldRT = RT.elementAt(0);
        float sumI = 0f;

        for (i = 0; i < size; i++) {
            ret += IC.elementAt(i).floatValue();
            System.out.println(RT.elementAt(i) + " " + IC.elementAt(i));
            if (RT.elementAt(i).floatValue() == oldRT) {
                sumI += IC.elementAt(i).floatValue();
            } else {
//                System.out.println(oldRT + " " + sumI);
                oldRT = RT.elementAt(i).floatValue();
                sumI = IC.elementAt(i).floatValue();
            }

        }
        //      System.out.println(oldRT + " " + sumI);

        return ret;
    }

//    public int findIndex(Vector<Float> vector, float target) {
//        int size = vector.size();
//        int ret = -1;
//        int index = 0;
//        int l_ind = 0;
//        int u_ind = size - 1;
//        float val = -1;
//        boolean found = false;
//
//        if (size == 0) {
//            ret = 0;
//            found = true;
//        } else {
//            val = vector.elementAt(0);
//            if (target < val) {
//                ret = 1;
//                found = true;
//            }
//            val = vector.elementAt(u_ind);
//            if ((target > val) && (!found)) {
//                ret = u_ind + 1;
//                found = true;
//            }
//        }
//
//        while (!found) {
//            index = Double.valueOf(Math.floor((u_ind - l_ind) / 2) + l_ind).intValue();
//            val = vector.elementAt(index);
//            if (l_ind + 1 >= u_ind) {
//                found = true;
//                ret = u_ind + 1;
//            } else {
//                if (val > target) {
//                    u_ind = index;
//                } else {
//                    if (val < target) {
//                        l_ind = index;
//                    } else {
//                        found = true;
//                        ret = index;
//                        while ((vector.elementAt(ret - 1) == target) && (ret > 0)) {
//                            ret--;
//                        }
//                    }
//                }
//            }
//        }
//        return ret;
//    }
//
    public boolean stop() {
        System.out.println(getName() + ": stopping...");
        return true;
    }

    public boolean supportMS1(){
        return true;
    }

    public boolean supportMS2(){
        return true;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
       return description;
    }
    private final static String name = "ComputeLcMsAreas";
    private final static String version = "0.1";
//    private final static String type = "QUANT_plugin";
    private final static String description = "This plugin reads in LC/MS peak correspondences and computes the area in the time domain with Simpson's rule.";
}