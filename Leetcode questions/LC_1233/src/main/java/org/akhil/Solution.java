package org.akhil;

import java.util.*;

public class Solution {

    // Solution 1 - bruteforce (Accepted)
    // TC -> O(NlogN * M) where M is the length of longest path in folder
    // SC -> O(N + M) where M is the length of longest path in folder
//    public List<String> removeSubfolders(String[] folder) {
//        List<String> result = new ArrayList<>();            // in worst case space complexity of O(N)
//        int n = folder.length;
//        if(n == 1){
//            result.add(folder[0]);
//            return result;
//        }
//
//        Arrays.sort(folder);        // O(NLogN * M)
//        int p1 = 0;
//        int p2 = 1;
//
//        result.add(folder[p1]);
//
//        while(p2 < n){                          // O(N)
//            String[] path1 = folder[p1].split("/");                 // space complexity of O(M)
//            String[] path2 = folder[p2].split("/");                 // space complexity of O(M)
//            boolean isSubfolder = true;
//
//            for(int index = 0; index < path1.length; index++){          // O(M) where M is length of longest path in folder
//                if(!path1[index].equals(path2[index])){
//                    isSubfolder = false;
//                    break;
//                }
//            }
//
//            if(!isSubfolder){
//                result.add(folder[p2]);
//                p1 = p2;
//            }
//            p2++;
//        }
//
//        return result;
//    }


    // Solution 2 - Same approach but reduce path1 and path2 array and their iteration
    // If we observe the definition of subfolder then a folder is subfolder of some other folder then the subfolder must
    // have actual folder path at the start (i.e. as '/a/b/c' is a subfolder of '/a/b' hence '/a/b/c' start with '/a/b' i.e. parent folder path
    // This is what we can utilize (after sorting if current folder path doesnot start with previous folder path then that means
    // it is definitely not a subfolder.

    // TC -> O(NlogN * M)
    // SC -> O(N + M)

    public List<String> removeSubfolders(String[] folder) {
        List<String> result = new ArrayList<>();            // in worst case space complexity of O(N)
        int n = folder.length;
        if(n == 1){
            result.add(folder[0]);
            return result;
        }

        Arrays.sort(folder);        // O(NLogN * M)
        int p1 = 0;
        String prev = folder[p1];

        while(p1 < n){              // O(N)
            String prevPath = prev+"/";                 // O(M) string concatenation

            if(!folder[p1].startsWith(prevPath)){       // O(M) string comparison
                prev = folder[p1];
                result.add(folder[p1]);
            }
            p1++;
        }

        return result;
    }
}
