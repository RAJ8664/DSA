//Same Solution in java is giving TLE;
class TimeMap {
private:
    struct Pair {
        std::string value;
        int time;
        Pair(std::string val, int t) : value(val), time(t) {}
        bool operator<(const Pair& other) const {
            return time < other.time;
        }
    };
    std::map<std::string, std::set<Pair>> mp;
public:
    TimeMap() {
    }
    void set(std::string key, std::string value, int timestamp) {
        Pair p(value, timestamp);
        mp[key].insert(p); 
    }
    std::string get(std::string key, int timestamp) {
        if (mp.find(key) == mp.end()) return ""; 
        const std::set<Pair>& s = mp[key];
        Pair temp("", timestamp);
        auto it = s.upper_bound(temp);
        if (it == s.begin()) return ""; 
        --it;
        return it->value;
    }
};