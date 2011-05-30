package xtracker;

import java.util.*;

/**
 * xSpectrum is the data structure housing the peak list (i.e. intensity over m/z values) both at the MS and MS/MS levels.
 * <p>
 * It is constituted by a vector of entries <code>mz</code> representing mass over charge values and a vector of intensities. <strong>Please note that
 * values are ordered by mz <u>increasingly</u>.</strong>
 * @see xLcMsData
 * @see xLcMsMsData
 * @author Dr. Luca Bianco (l.bianco@cranfield.ac.uk) -- Cranfield Health, Cranfield University -- X-Tracker Project
 */
public class xSpectrum {


    /**
     * The constructor, creates empty vectors for mz and Intensities.
     */
    public xSpectrum(){
       mz = new Vector<Float>();
       intensity = new Vector<Float>();
    }




     /**
     * Adds an element to the spectrum. An element is a couple (mzValue,intensityValue).
     * <strong>Please note that the Vector of elements is ordered <u>increasingly</u> by mzValue</strong>
     * <p>
     * @param mzValue is the m/z value.
     * @param intensityValue is the intensity value.
     */
    public void addElem(float mzValue, float intensityValue){
        int pos=Collections.binarySearch(mz, mzValue);

        if(pos<0){
            pos=0-pos-1;
            mz.add( pos,mzValue);
            intensity.add(pos,intensityValue);
          }
         else{
              mz.add( pos,mzValue);
              intensity.add(pos,intensityValue);

            }


        //OLD CODE
        /*
        int u_ind=mz.size();
        int l_ind=1;
        int index=-1;
        float value=-1f;


        boolean found = false;
        //Vector empty let's add a value somewhere, does not matter!
        if(u_ind==0){

                    mz.add(mzValue);
                    intensity.add(intensityValue);

        }
        else{

            value=mz.elementAt(u_ind-1);

            if(mzValue>= value){
                    /**
                     * The mzValue of the element we are inserting is higher than that of the last element
                     * inserted, so the values will be added at the end of the structure.
                     */
/*                    mz.add(mzValue);
                    intensity.add(intensityValue);

            }
            else{
                value=mz.elementAt(l_ind-1);

                if(mzValue<= value){
                        /**
                         * The mzValue of the element we are inserting is smaller than that of the first element
                         * inserted, so the values will be added at the beginning of the structure.
                         */
  /*                       if(mzValue==value){

                                mz.add(1,mzValue);
                                intensity.add(1,intensityValue);
                         }
                         else{
                                mz.add(0,mzValue);
                                intensity.add(0,intensityValue);
                         }
                }

                else{
                    /**
                     * The general case... the element we want is somewhere in the middle of the structure.
                     */
   /*                  while(! found){
                            if(l_ind+1>=u_ind){
                                found=true;
                                mz.add(u_ind-1,mzValue);
                                intensity.add(u_ind-1,intensityValue);

                            }
                            else{
                                index= Double.valueOf(Math.floor((u_ind-l_ind)/2) + l_ind).intValue();

                                if(mzValue>value){
                                        l_ind=index;
                                }
                                else{
                                    if(mzValue<value){
                                        u_ind=index;
                                    }
                                 else{
                                        mz.add(index,mzValue);
                                        intensity.add(index,intensityValue);
                                        found=true;
                                    }
                                }
                            }
                     }

                }


            }



        }

     */

    }




    /**
     * Performs a binary search looking for the index of the first element in the structure
     * having a mz Value higher than the <code>target</code>.
     * @param target is the target mz value.
     * @return the index of the first element having mz value higher than <code>target</target> <strong>Please note that the method
     * returns <code>-1</code> if all elements in the structure are smaller than <code>target</code>.</strong>
     */
    public int getIndexOfFirstHigherThan(float target){
        int ret=-1;

        int index=Collections.binarySearch(mz, target);
        if(index>0){
         ret=index;
        }
        else{
         ret=0-index-1;
        }
        //OLD CODE
        /*

        int ret=-1;
        int l_ind=0;
        int u_ind=mz.size()-1;
        int index=-1;
        float val=-1f;
        boolean found =false;
        if(target>mz.elementAt(u_ind)){
            ret=-1;
            found=true;

        }
        while(! found){
            index= Double.valueOf(Math.floor((u_ind-l_ind)/2) + l_ind).intValue();
            val=mz.elementAt(index);
            if(l_ind+1>=u_ind){
                found=true;
                ret=u_ind;
            }
            else{
                if(val>target){
                    u_ind=index;
                }
                else{
                    if(val<target){
                       l_ind=index;
                    }
                    else{
                        found=true;
                        ret=index;
                        while((mz.elementAt(ret-1)==target)&&(ret>0)){
                           ret--;
                        }

                    }

                }

            }

        }
        */
       return ret;
    }


    /**
     * Performs a binary search looking for the index of the last element in the structure
     * having a mz value smaller than the <code>target</code>.
     * @param target is the target mz value.
     * @return the index of the last element having mz value smaller than <code>target</target>. <strong>Please note that the method
     * returns <code>-1</code> if all elements in the structure are higher than <code>target</code>.</strong>
     */
    public int getIndexOfLastSmallerThan(float target){
        int ret=-1;

        int index=Collections.binarySearch(mz, target);
        if(index>0){
         ret=index;
        }
        else{
         ret=0-index-2;
        }
        //OLD CODE
        /*
        int ret=-1;
        int l_ind=0;
        int u_ind=mz.size()-1;
        int index=-1;
        float val=-1f;
        boolean found =false;
        if(target<mz.elementAt(0)){
            found=true;
            ret=-1;
        }
        while(! found){
            index= Double.valueOf(Math.floor((u_ind-l_ind)/2) + l_ind).intValue();
            val=mz.elementAt(index);
            if(l_ind+1>=u_ind){
                found=true;
                ret=l_ind;
            }
            else{
                if(val>target){
                    u_ind=index;
                }
                else{
                    if(val<target){
                       l_ind=index;
                    }
                    else{
                        found=true;
                        ret=index;
                        int size=mz.size()-1;
                        while((mz.elementAt(ret+1)==target) && (ret<size)){
                           ret++;
                        }

                    }

                }

            }

        }
        */
       return ret;
    }


        /**
     * Performs two binary searches looking for the elements in the structure
     * having a mz value smaller than the <code>upper</code> and higher than <code>lower</code>.
     * @param lower is the lower acceptable mz value.
     * @param upper is the upper acceptable mz value.
     * @return the array containing the index of the lower element having mz smaller than <code>target</target>. <strong>Please note that the method
     * returns <code>empty array</code> if all elements in the structure are higher than <code>target</code>.</strong> <p>This means that:<br>
     * res[i][0] is the mz value of the i-th peak having mz values between lower and upper.<br>
     * res[i][1] is the intensity value of the i-th peak having mz values between lower and upper.<br>
     */
    public float[][] getSubspectrumBetween(float lower,float upper){
        float[][] ret;
        int min=0;
        int max=0;
        //
        if(lower>upper){
            float tmp;
            tmp=upper;
            upper=lower;
            lower=tmp;

        }
  //              System.out.println("Bounds: Lower " + lower + " Upper " +upper);
  //              for(int i=0;i<this.getSize();i++){
    //                float[][]spec = this.getSpectrum();
     //               System.out.println("(" +i+ ") mz: " + spec[i][0]);

     //           }

        max=this.getIndexOfLastSmallerThan(upper);
        min=this.getIndexOfFirstHigherThan(lower);
//                System.out.println("Min:" + min + " Max:" +max);
        if((min==-1)||(max==-1)||(min>max)){
            ret= new float[0][0];
        }
        else{
            ret=new float[max-min+1][2];

            int elCounter=0;
            for(int i=min;i<=max;i++){
                ret[elCounter][0]=mz.elementAt(i);
                ret[elCounter][1]=intensity.elementAt(i);
                elCounter++;
             }
        }


        return ret;
    }


    /**
     * Gets the whole spectrum. Please remember that the structure is ordered increasingly by mz.
     * @return A double array of floats representing the spectrum. In particular:<br>
     * ret[i][0] is the i-th mz value.<br>
     * ret[i][1] is the i-th intensity value.
     *
     */
    public float[][] getSpectrum(){
        float[][] ret = new float[this.getSize()][2];
            for(int i=0;i<getSize();i++){
                ret[i][0]=mz.elementAt(i);
                ret[i][1]=intensity.elementAt(i);

            }

        return ret;
    }

    /**
     * getSize computes the size of the spectrum.
     * <p>
     * @return the size of the dataset
     */
    public int getSize(){
        return mz.size();
    }

    /**
     * Vector of mz values.
     * @see xLcMsData
     * @see xLcMsMsData
     */
    public Vector<Float> mz;

    /**
     * The vector of intensities.
     * @see xLcMsData
     * @see xLcMsMsData
     */
    public Vector<Float> intensity;
}
