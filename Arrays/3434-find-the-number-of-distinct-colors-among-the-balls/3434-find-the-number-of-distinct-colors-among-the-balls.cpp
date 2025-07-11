class Solution {
public:
    vector<int> queryResults(int limit, vector<vector<int>>& queries) {
        vector<int> res;
        map<int, int> count;
        map<int, int> colours;
        set<int> st;
        for (int i = 0; i < queries.size(); i++) {
            int balloon = queries[i][0];
            int color = queries[i][1];
            if (st.count(balloon)) {
                count[colours[balloon]]--;
                if(count[colours[balloon]] == 0) count.erase(colours[balloon]);
                colours[balloon] = color;
                count[color]++;
            }
            else {
                st.insert(balloon);
                colours[balloon] = color;
                count[color]++;
            }
            res.push_back(count.size());
        }
        return res;
    }
};