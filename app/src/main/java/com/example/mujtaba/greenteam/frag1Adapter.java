package com.example.mujtaba.greenteam;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ramotion.foldingcell.FoldingCell;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Mujtaba on 10/14/2018.
 */

public class frag1Adapter extends RecyclerView.Adapter<frag1Adapter.ViewHolder> {
    private Context context;
    private List<Live_Score> matchdata;


    public frag1Adapter(Context context,List<Live_Score> a ) {
        this.context = context;
       matchdata =a;
    }

    @Override
    public frag1Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.frag1card,parent,false);

        return new frag1Adapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Live_Score score = matchdata.get(position);
        if(score.getBatsmen1()==null)
        {            holder.team1score1.setText("Yet to bat");
            holder.team1overs1.setText("");
            holder.team2score1.setText("Yet to bat");
            holder.team2overs1.setText("");
        }
        else {
            holder.Batsmen1name.setText(score.getBatsmen1().getName());
            holder.Batsmen1runs.setText(score.getBatsmen1().getRuns());
            holder.Batsmen1balls.setText(score.getBatsmen1().getBalls());
            holder.Batsmen1fours.setText(score.getBatsmen1().getFours());
            holder.Batsmen1sixes.setText(score.getBatsmen1().getSixes());
            holder.Batsmen1SR.setText(score.getBatsmen1().getStrikerate());

            holder.Batsmen2name.setText(score.getBatsmen2().getName());
            holder.Batsmen2runs.setText(score.getBatsmen2().getRuns());
            holder.Batsmen2balls.setText(score.getBatsmen2().getBalls());
            holder.Batsmen2fours.setText(score.getBatsmen2().getFours());
            holder.Batsmen2sixes.setText(score.getBatsmen2().getSixes());
            holder.Batsmen2SR.setText(score.getBatsmen2().getStrikerate());

            holder.Bowler1name.setText(score.getBowler1().getName());
            holder.Bowler1overs.setText(score.getBowler1().getOvers());
            holder.Bowler1runs.setText(score.getBowler1().getRuns());
            holder.Bowler1wickets.setText(score.getBowler1().getWickets());
            holder.Bowler1maidens.setText(score.getBowler1().getMaiden());
            holder.Bowler1Eco.setText("--");

            holder.Bowler2name.setText(score.getBowler2().getName());
            holder.Bowler2overs.setText(score.getBowler2().getOvers());
            holder.Bowler2runs.setText(score.getBowler2().getRuns());
            holder.Bowler2wickets.setText(score.getBowler2().getWickets());
            holder.Bowler2maidens.setText(score.getBowler2().getMaiden());
            holder.Bowler2Eco.setText("--");

            holder.team1score1.setText(score.getT1score());
            holder.team1overs1.setText(score.getT1over());
            holder.team2score1.setText(score.getT2score());
            holder.team2overs1.setText(score.getT2over());
            String temp = score.getToss() + " Won the toss and has Elected to " + score.getDecision()+ " First";
            holder.toss.setText(temp);
        }
        holder.toss.setVisibility(View.INVISIBLE);

        holder.team1name.setText(score.getTeam1());
        holder.team2name.setText(score.getTeam2());


        holder.status.setText(score.getMatchstatus());
        
        if (score.getTeam1().equals("England"))holder.t1flag.setImageResource(R.drawable.ic_england);
        else if (score.getTeam1().equals("India")) holder.t1flag.setImageResource(R.drawable.ic_india);
        else if (score.getTeam1().equals("Pakistan")) holder.t1flag.setImageResource(R.drawable.ic_pakistan);
        else if (score.getTeam1().equals("Bangladesh")) holder.t1flag.setImageResource(R.drawable.ic_bangladesh);
        else if (score.getTeam1().equals("Sri Lanka")) holder.t1flag.setImageResource(R.drawable.ic_sri_lanka);
        else if (score.getTeam1().equals("New Zealand")) holder.t1flag.setImageResource(R.drawable.ic_new_zealand);
        else if (score.getTeam1().equals("Australia")) holder.t1flag.setImageResource(R.drawable.ic_australia);
        else if (score.getTeam1().equals("South Africa")) holder.t1flag.setImageResource(R.drawable.ic_south_africa);
        else if (score.getTeam1().equals("Afghanistan")) holder.t1flag.setImageResource(R.drawable.ic_afghanistan);
        else holder.t1flag.setImageResource(R.color.colorAccent);

        if (score.getTeam2().equals("England"))holder.t2flag.setImageResource(R.drawable.ic_england);
        else if (score.getTeam2().equals("India")) holder.t2flag.setImageResource(R.drawable.ic_india);
        else if (score.getTeam2().equals("Pakistan")) holder.t2flag.setImageResource(R.drawable.ic_pakistan);
        else if (score.getTeam2().equals("Bangladesh")) holder.t2flag.setImageResource(R.drawable.ic_bangladesh);
        else if (score.getTeam2().equals("Sri Lanka")) holder.t2flag.setImageResource(R.drawable.ic_sri_lanka);
        else if (score.getTeam2().equals("New Zealand")) holder.t2flag.setImageResource(R.drawable.ic_new_zealand);
        else if (score.getTeam2().equals("Australia")) holder.t2flag.setImageResource(R.drawable.ic_australia);
        else if (score.getTeam2().equals("South Africa")) holder.t2flag.setImageResource(R.drawable.ic_south_africa);
        else if (score.getTeam2().equals("Afghanistan")) holder.t2flag.setImageResource(R.drawable.ic_afghanistan);
        else holder.t2flag.setImageResource(R.color.colorAccent);
    }

    @Override
    public int getItemCount() {
        return matchdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView Batsmen1name,Batsmen1runs,Batsmen1balls,Batsmen1fours,Batsmen1sixes,Batsmen1SR;
        TextView Batsmen2name,Batsmen2runs,Batsmen2balls,Batsmen2fours,Batsmen2sixes,Batsmen2SR;
        TextView Bowler1name,Bowler1runs,Bowler1overs,Bowler1wickets,Bowler1maidens,Bowler1Eco;
        TextView Bowler2name,Bowler2runs,Bowler2overs,Bowler2wickets,Bowler2maidens,Bowler2Eco;
        TextView team1name, team1score1, team1overs1,team1score2,team1overs2;
        TextView team2name, team2score1, team2overs1,team2score2,team2overs2;
        TextView toss, status;
        ImageView t1flag, t2flag;


        final FoldingCell fc;
        public ViewHolder(View itemView) {
            super(itemView);
            Batsmen1name = (TextView)itemView.findViewById(R.id.Batsmen1name);
            Batsmen1runs = (TextView)itemView.findViewById(R.id.Batsmen1runs);
            Batsmen1balls = (TextView)itemView.findViewById(R.id.Batsmen1balls);
            Batsmen1fours = (TextView)itemView.findViewById(R.id.Batsmen1fours);
            Batsmen1sixes = (TextView)itemView.findViewById(R.id.Batsmen1sixes);
            Batsmen1SR = (TextView)itemView.findViewById(R.id.Batsmen1SR);

            Batsmen2name = (TextView)itemView.findViewById(R.id.Batsmen2name);
            Batsmen2runs = (TextView)itemView.findViewById(R.id.Batsmen2runs);
            Batsmen2balls = (TextView)itemView.findViewById(R.id.Batsmen2balls);
            Batsmen2fours = (TextView)itemView.findViewById(R.id.Batsmen2fours);
            Batsmen2sixes = (TextView)itemView.findViewById(R.id.Batsmen2sixes);
            Batsmen2SR = (TextView)itemView.findViewById(R.id.Batsmen2SR);

            Bowler1name = (TextView)itemView.findViewById(R.id.Bowler1name);
            Bowler1runs = (TextView)itemView.findViewById(R.id.Bowler1runs);
            Bowler1overs = (TextView)itemView.findViewById(R.id.Bowler1overs);
            Bowler1wickets = (TextView)itemView.findViewById(R.id.Bowler1wickets);
            Bowler1maidens = (TextView)itemView.findViewById(R.id.Bowler1maidens);
            Bowler1Eco = (TextView)itemView.findViewById(R.id.Bowler1Eco);


            Bowler2name = (TextView)itemView.findViewById(R.id.Bowler2name);
            Bowler2runs = (TextView)itemView.findViewById(R.id.Bowler2runs);
            Bowler2overs = (TextView)itemView.findViewById(R.id.Bowler2overs);
            Bowler2wickets = (TextView)itemView.findViewById(R.id.Bowler2wickets);
            Bowler2maidens = (TextView)itemView.findViewById(R.id.Bowler2maidens);
            Bowler2Eco = (TextView)itemView.findViewById(R.id.Bowler2Eco);

            team1name =  (TextView)itemView.findViewById(R.id.t1name);
            team1score1 =  (TextView)itemView.findViewById(R.id.t1score1);
            team1overs1 =  (TextView)itemView.findViewById(R.id.t1overs1);
            team2name =  (TextView)itemView.findViewById(R.id.t2name);
            team2score1 =  (TextView)itemView.findViewById(R.id.t2score1);
            team2overs1 =  (TextView)itemView.findViewById(R.id.t2overs1);

            toss = (TextView) itemView.findViewById(R.id.toss1);
            status = (TextView) itemView.findViewById(R.id.status);
            t1flag  = (ImageView) itemView.findViewById(R.id.t1flag);
            t2flag  = (ImageView) itemView.findViewById(R.id.t2flag);
            fc = (FoldingCell) itemView.findViewById(R.id.folding_cell);

            fc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fc.toggle(false);
                }
            });
        }
    }
}
