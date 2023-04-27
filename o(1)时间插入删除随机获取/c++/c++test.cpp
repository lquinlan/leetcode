#include <bits/stdc++.h>
using namespace std;

class RandomizedSet
{
public:
    RandomizedSet() : my_map(200001)
    {
    }

    bool insert(int val)
    {
        int ind = gethash(val);
        for (auto i : my_map[ind])
        {
            if (i == val)
            {
                return false;
            }
        }
        my_map[ind].emplace_back(val);
        // if(my_map[ind].size()==1){
        //     index.emplace_back(ind);
        // }
        index.insert(ind);
        return true;
    }

    bool remove(int val)
    {
        int ind = gethash(val);
        for (int i = 0; i < my_map[ind].size(); i++)
        {
            if (my_map[ind][i] == val)
            {
                auto tmpind = my_map[ind].begin() + i;
                my_map[ind].erase(tmpind);
                if(my_map[ind].size()==0){
                    index.erase(ind);
                }
                return 1;
            }
        }
        return 0;
    }

    int getRandom()
    {
        

        
        return my_map[*(index.begin())][0];
    }

private:
    vector<vector<int>> my_map;
    // vector<int> index;
    unordered_set<int> index;
    int gethash(int val)
    {
        return val % 200001;
    }
};
int main()
{
    RandomizedSet ym;
    // cout << ym.getRandom() << endl;
    cout << "Welcome" << endl;
    return 0;
}