package com.coursera.cpayanf.materialapp;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Adapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	SwipeRefreshLayout rfhRefreshLista;
	ListView lsvLista;
	Adapter goAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		accionesFabAdd();

		rfhRefreshLista = findViewById(R.id.rfhRefreshLista);
		lsvLista = findViewById(R.id.lsvLista);

		String[] laPlanetas = getResources().getStringArray(R.array.planetas);
		lsvLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, laPlanetas));
		rfhRefreshLista.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				refrescarLista();
			}
		});
	}

	public void refrescarLista(){
		String[] laPlanetas = getResources().getStringArray(R.array.planetas);
		lsvLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, laPlanetas));
		rfhRefreshLista.setRefreshing(false);
	}

	public void accionesFabAdd(){
		FloatingActionButton fabAdd = findViewById(R.id.fabAdd);
		fabAdd.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				//Toast.makeText(getBaseContext(), getResources().getString(R.string.msjPresiono), Toast.LENGTH_SHORT).show();
				Snackbar.make(v, getResources().getString(R.string.msjPresiono), Snackbar.LENGTH_SHORT)
						.setAction(getResources().getString(R.string.snkAccion), new View.OnClickListener(){
							@Override
							public void onClick(View v){
								Toast.makeText(getBaseContext(), getResources().getString(R.string.msjPresiono), Toast.LENGTH_SHORT).show();
							}
						})
						.setActionTextColor(getResources().getColor(R.color.colorPrimary))
						.show();
			}
		});
	}

}
