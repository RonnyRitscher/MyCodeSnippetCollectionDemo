package de.ronnyritscher.projekt_codesnippetcollectionapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MyViewHolder> {

    private static final String TAG = MainRecyclerViewAdapter.class.getSimpleName();

    //MyViewHolder (innerClass)
    public static class MyViewHolder  extends RecyclerView.ViewHolder{

        //MEMBER: Wir benötigen Member
        public TextView demoName;
        public TextView demoDiscription;
        public TextView demoClassName;

        //CONSTRUCTOR
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            demoName = itemView.findViewById(R.id.tv_main_item_demoName);
            demoDiscription = itemView.findViewById(R.id.tv_main_item_demoDescription);
            demoClassName = itemView.findViewById(R.id.tv_main_item_demoClassName);

        }
    }

    @NonNull
    @Override
    public MainRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //LayoutInflater
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_main_layout, null);

        // wir erzeugen ein neuen VH und geben diesen zurück
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainRecyclerViewAdapter.MyViewHolder viewHolder, int i) {
        // besogt die Daten aus der Array-Liste (MainActivity.demoArrayList)
        // und fügt diese in die platzhalter der items der RV ein...
        viewHolder.demoName.setText(MainActivity.demoArrayList.get(i).getName());
        viewHolder.demoDiscription.setText(MainActivity.demoArrayList.get(i).getDescription());
        viewHolder.demoClassName.setText(MainActivity.demoArrayList.get(i).getClassName());

        //Hier können wir die einzelnen Elemente anklicken -> neue Activity starten
        viewHolder.itemView.setOnClickListener( (v) -> {


            Log.d(TAG, "PackageName: "+v.getContext().getPackageName());
            Log.d(TAG, "activityToStart: " + v.getContext().getPackageName().concat(".").concat(viewHolder.demoClassName.getText().toString()));

            //PackageName+Trennzeichen+ActivityName identifizieren
            String activityToStart =  v.getContext().getPackageName().concat(".").concat(viewHolder.demoClassName.getText().toString());
            //String activityToStart =  v.getContext().getPackageName().concat(".").concat(viewHolder.demoClassName.getText().toString());
            try {
                Class<?> activityToStartClass = Class.forName(activityToStart);   //ClassObjekt aus dem String erhalten
                Log.d(TAG, "activityToStartClass: "+activityToStartClass);
                Intent intent = new Intent(v.getContext(), activityToStartClass);       //Intent erzeugen
                v.getContext().startActivity(intent);                                   //start Activity
            } catch (ClassNotFoundException ignored) {
                Toast.makeText(v.getContext(), "ClassNotFoundException", Toast.LENGTH_SHORT).show();
            }

//            String activitiName = "AlertDialogDemoActivity.class";
//            Class<?> myClass = Class.forName(activitiName);
//
//            Intent intent = new Intent(v.getContext() , activitiName);
//            v.getContext().startActivity(intent);
            //viewHolder.itemView.getContext().startActivity(new Intent(viewHolder.itemView.getContext(), viewHolder.demoClassName));

        });
    }

    @Override
    public int getItemCount() {
        return MainActivity.demoArrayList.size(); // Gibt die Größe der Liste an/zurück
    }



}
