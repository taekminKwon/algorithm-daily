import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        FileInfo[] fileInfos = new FileInfo[files.length];
        String[] answer = new String[files.length];
        
        for (int i = 0; i < files.length; i++) {
            fileInfos[i] = getFileInfo(new FileInfo(), files[i], i);
        }
        
        Arrays.sort(fileInfos, (file1, file2) -> {
            String f1Head = file1.head.toUpperCase();
            String f2Head = file2.head.toUpperCase();
            if (!f1Head.equals(f2Head)) {
                return f1Head.compareTo(f2Head);
            }
            
            int f1No = file1.number;
            int f2No = file2.number;
            if (f1No != f2No) {
                return Integer.compare(f1No, f2No);
            }
            
            return Integer.compare(file1.index, file2.index);
        });
        
        for (int i = 0; i < files.length; i++) {
            answer[i] = files[fileInfos[i].index];
        }
        return answer;
    }
    
    static FileInfo getFileInfo(FileInfo fi, String fileName, int index) {        
        int firstNumberIndex = 0;
        for (int i = 0; i < fileName.length(); i++) {
            char c = fileName.charAt(i);
            if ('0' <= c && c <= '9') {
                fi.head = fileName.substring(0, i);
                firstNumberIndex = i;
                break;
            }
        }
        
        int lastNumberIndex = firstNumberIndex;
        while (lastNumberIndex < fileName.length() && '0' <= fileName.charAt(lastNumberIndex) && fileName.charAt(lastNumberIndex) <= '9') {
            lastNumberIndex++;
        }
        
        fi.number = Integer.parseInt(fileName.substring(firstNumberIndex, lastNumberIndex));
        fi.index = index;
        
        return fi;
    }
    
    class FileInfo {
        String head;
        int number;
        int index;
        
        public String toString() {
            return "head : " + head +
                ", number : " + number +
                ", index : " + index;
        }
    }
}