package com.magiccodeinc.porcsmartbeta;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;

    private FrameLayout adContainer; // Nuevo: contenedor del banner
    private BannerAdManager bannerAdManager;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configurar Edge-to-Edge
        Window window = getWindow();
        WindowCompat.setDecorFitsSystemWindows(window, false);
        setContentView(R.layout.activity_main);

        // Inicializar Toolbar
        toolbar = findViewById(R.id.toolbar);

        // Inicializar el SDK de AdMob
        MobileAds.initialize(this, initializationStatus -> {});

        enableEdgeToEdge(); // Habilita edge-to-edge correctamente

        // Inicialización del contenedor del banner
        adContainer = findViewById(R.id.ad_view_container);
        bannerAdManager = new BannerAdManager(this, adContainer);
        bannerAdManager.loadAd();

        // Configuración de la Toolbar
        setupToolbar();

        // Configuración de Edge-to-Edge
        setupEdgeToEdge();

        ViewPager viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.white));

        cambiarColores(getColorForTab(0));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Llama a cambiarColores con colores según la posición
                cambiarColores(getColorForTab(tab.getPosition()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

            // Otros métodos de TabLayout.OnTabSelectedListener
        });
    }

    // Método para obtener colores según la posición de la pestaña

    @SuppressLint("ObsoleteSdkInt")
    public void cambiarColores(int color) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(color));
        }
        toolbar.setBackgroundColor(color);
        tabLayout.setBackgroundColor(color);

        // Cambiar color de la barra del estado de forma compatible con Android 15+
        if (Build.VERSION.SDK_INT >= 34) { // Android 15 (Upside Down Cake)
            final Window window = getWindow();
            final WindowInsetsController insetsController = window.getInsetsController();
            if (insetsController != null) {
                insetsController.setSystemBarsAppearance(0, WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS);
                window.setDecorFitsSystemWindows(false);
                window.setStatusBarColor(color); // No hay método directo aún, pero se recomienda usar temas o insetsController
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(color);
        }
    }

    private int getColorForTab(int position) {
        switch (position) {
            case 0:
                return ContextCompat.getColor(this, R.color.yellow);
            case 1:
                return ContextCompat.getColor(this, R.color.blue);
            case 2:
                return ContextCompat.getColor(this, R.color.pinkbubble);
            case 3:
                return ContextCompat.getColor(this, R.color.white);
        }
        return position;
    }


    private void setupToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    private void setupEdgeToEdge() {
        Window window = getWindow();
        WindowCompat.setDecorFitsSystemWindows(window, false);

        // Controlar visibilidad de íconos en barras
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(window, window.getDecorView());
        insetsController.setAppearanceLightStatusBars(true);
        insetsController.setAppearanceLightNavigationBars(true);

        // Ajuste de padding para la toolbar
        if (toolbar != null) {
            ViewCompat.setOnApplyWindowInsetsListener(toolbar, (v, insets) -> {
                int top = insets.getInsets(WindowInsetsCompat.Type.systemBars()).top;
                v.setPadding(v.getPaddingLeft(), top, v.getPaddingRight(), v.getPaddingBottom());
                return insets;
            });
        }
    }

    // Método para habilitar edge-to-edge manualmente
    private void enableEdgeToEdge() {
        Window window = getWindow();
        WindowCompat.setDecorFitsSystemWindows(window, false);

        // Controlar visibilidad de íconos en barras
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(window, window.getDecorView());
        insetsController.setAppearanceLightStatusBars(true);
        insetsController.setAppearanceLightNavigationBars(true);

        // Ajuste de padding para la toolbar
        if (toolbar != null) {
            ViewCompat.setOnApplyWindowInsetsListener(toolbar, (v, insets) -> {
                int top = insets.getInsets(WindowInsetsCompat.Type.systemBars()).top;
                v.setPadding(v.getPaddingLeft(), top, v.getPaddingRight(), v.getPaddingBottom());
                return insets;
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_help) {
            // Realiza alguna acción cuando se hace clic en el elemento de menú "Acerca de"
            MyDialogFragment dialog = new MyDialogFragment();
            dialog.show(getSupportFragmentManager(), "about_dialog");
            return true;
        }

        if (id == R.id.action_police) {
            // Realiza alguna acción cuando se hace clic en el elemento de menú "Política de Privacidad"
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://sites.google.com/view/porcsmartbeta/"));
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_pro) {
            // Realiza alguna acción cuando se hace clic en el elemento de menú "Política de Privacidad"
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.magiccodeinc.porcsmartpro"));
            startActivity(intent);
            return true;
        }

        // Maneja otros elementos de menú aquí si es necesario

        return super.onOptionsItemSelected(item);
    }
}
