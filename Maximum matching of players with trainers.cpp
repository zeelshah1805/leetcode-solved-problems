class Solution {
public:
    int matchPlayersAndTrainers(vector<int>& players, vector<int>& trainers) {
        sort(players.begin(), players.end());
        sort(trainers.begin(), trainers.end());

        int cnt=0;
        int found=0;

        for(int i=0; i<players.size(); i++)
        {
            auto x= lower_bound(trainers.begin()+found, trainers.end(), players[i])-trainers.begin();

            if (x==trainers.size())
                break;

            cnt++;
            found=x+1;
        }

        return cnt;
        
    }
};
