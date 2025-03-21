import java.util.*;
public class DS2115 {
        public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
            int n=recipes.length;
            HashMap<String,Integer> receipeMap= new HashMap<>();
            for(int i=0;i<n;i++){
                receipeMap.put(recipes[i],i);
            }
            HashSet<String> suppliesSet= new HashSet<>();
            for(int i=0;i<supplies.length;i++){
                suppliesSet.add(supplies[i]);
            }
            HashSet<Integer>impossibleReceipe = new HashSet<>();
            List graph[]= new List[n];
            for(int i=0;i<n;i++){
                graph[i]= new LinkedList<Integer>();
            }
            for(int i=0;i<n;i++){
                List<String> l =ingredients.get(i);
                for(int j=0;j<l.size();j++){
                    if(suppliesSet.contains(l.get(j)))
                    continue;
                    else if(receipeMap.containsKey(l.get(j))){
                        graph[receipeMap.get(l.get(j))].add(i);
                    }else{
                         impossibleReceipe.add(i);
                    }
                }
            }
    
           int indegree[]= new int[n];
    
           for(int i=0;i<graph.length;i++){
            List<Integer> l=graph[i];
            for(int j=0;j<l.size();j++){
               indegree[l.get(j)]++;
            }
           }
    
           Queue<Integer> q = new LinkedList<>();
    
           List<String> ans = new LinkedList<>();
    
           for(int i=0;i<n;i++){
             if(!impossibleReceipe.contains(i)&&indegree[i]==0){
                q.add(i);
             }
           }
    
           while(!q.isEmpty()){
              
              int currentReceipe=q.poll();
              ans.add(recipes[currentReceipe]);
    
              List<Integer> l =graph[currentReceipe];
    
              for(int k: l){
                indegree[k]--;
    
                if(indegree[k]==0)
                q.add(k);
              }
           }
    
           return ans;
            
        }
    
}
