package com.magiccodeinc.porcsmartbeta.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.magiccodeinc.porcsmartbeta.CustomSpinnerAdapter;
import com.magiccodeinc.porcsmartbeta.R;

import java.text.DecimalFormat;
import java.util.Arrays;

public class TabFragment1 extends Fragment {

    private Spinner spinnerFormat;
    private EditText edtInitialValue;
    private EditText edtPercentage;
    private TextView tvResult;
    private DecimalFormat decimalFormat;

    public TabFragment1() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflar el diseño del fragmento
        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);

        spinnerFormat = rootView.findViewById(R.id.spinnerFormat);
        edtInitialValue = rootView.findViewById(R.id.edtInitialValue);
        edtPercentage = rootView.findViewById(R.id.edtPercentage);
        tvResult = rootView.findViewById(R.id.tvResult);

        // Obtén las opciones del array de recursos
        String[] formatOptions = getResources().getStringArray(R.array.format_options);

        // Crea el adaptador personalizado con las opciones (sin el primer elemento "Seleccionar formato")
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(requireActivity(), android.R.layout.simple_spinner_item, Arrays.asList(formatOptions));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Establece el adaptador en el Spinner
        spinnerFormat.setAdapter(adapter);


        decimalFormat = new DecimalFormat("0.00"); // Formato por defecto

        spinnerFormat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Configurar el formato decimal en función de la selección
                String selectedFormat = spinnerFormat.getSelectedItem().toString();
                switch (selectedFormat) {
                    case "0":
                        decimalFormat = new DecimalFormat("0");
                        break;
                    case "0.00":
                        decimalFormat = new DecimalFormat("0.00");
                        break;
                    case "0.000":
                        decimalFormat = new DecimalFormat("0.000");
                        break;
                    case "0.0000":
                        decimalFormat = new DecimalFormat("0.0000");
                        break;
                }

                // Calcular y mostrar el resultado nuevamente con el nuevo formato
                updateResult();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // No es necesario hacer nada aquí
            }
        });

        // Agrega TextWatchers a los campos de entrada para actualizar automáticamente
        edtInitialValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateResult();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        edtPercentage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateResult();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        return rootView;
    }

    @SuppressLint("SetTextI18n")
    private void updateResult() {
        String initialValueStr = edtInitialValue.getText().toString();
        String percentageStr = edtPercentage.getText().toString();

        if (!initialValueStr.isEmpty() && !percentageStr.isEmpty()) {
            double initialValue = Double.parseDouble(initialValueStr);
            double percentage = Double.parseDouble(percentageStr);
            double difference = (initialValue * percentage) / 100;
            tvResult.setText(decimalFormat.format(difference));
        } else {
            tvResult.setText("");
        }
    }
}

