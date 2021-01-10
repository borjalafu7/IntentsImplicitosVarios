package com.borjalapa.intentsimplicitosvarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //boton para abrir una pagina web en la app de google
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener((arg0) -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mestreacasa.gva.es/web/iesserraperenxisa/"));

            //Comprobamos de antemano que el Intent podrá ser gestionado sin petar
            //También se podría poner un try/catch
            if ( intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }
        });

        //boton para abrir el google maps
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener((arg0) -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com"));
            startActivity(intent);
        });

        //boton para abrir una ubicacion exacta en el google maps
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener((arg0) -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:39.4295152,-0.4660814?z=18"));
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        });

        //boton para abrir la app de llamadas del telefono con ese numero marcado
        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener((arg0) -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+95723423));

            //Comprobamos de antemano que el Intent podrá ser gestionado sin petar
            //También se podría poner un try/catch
            if (intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }
        });

        //boton para abrir una app y mandar textos planos
        //en este caso para mandar un correo con la app de gmail
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener((arg0) -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Probando");
            intent.putExtra(Intent.EXTRA_TEXT,"Esto es un texto de prueba");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"borjaalafu@gmail.com"});
            startActivity(intent);
        });


        //boton para abrir la camara y gurdar la foto
        //se necesita añadir esta linea en el manifest.xml
        // <uses-feature android:name="android.hardware.camera" android:required="true" />
        Button button6 = (Button)findViewById(R.id.button6);
        button6.setOnClickListener((arg0) -> {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");

            //Comprobamos de antemano que el Intent podrá ser gestionado sin petar
            //También se podría poner un try/catch
            if (intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }

        });


        //boton para setear una alarma con su mensaje y hora
        //se necesita añadir esta linea en el manifest.xml
        //<uses-permission android:name="com.android.alarm.permission.SET_ALARM" />
        Button button7 = (Button)findViewById(R.id.button7);
        button7.setOnClickListener((arg0)-> {
            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, "alarma de prueba")
                    .putExtra(AlarmClock.EXTRA_HOUR, 0)
                    .putExtra(AlarmClock.EXTRA_MINUTES, 45);

            //Comprobamos de antemano que el Intent podrá ser gestionado sin petar
            //También se podría poner un try/catch
            if (intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }

        });

        Button button8 = (Button)findViewById(R.id.button8);
        button8.setOnClickListener((arg0) -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + 666006670));
            intent.putExtra("sms_body", "Texto mensaje");

            //Comprobamos de antemano que el Intent podrá ser gestionado sin petar
            //También se podría poner un try/catch
            if (intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }
        });

        //abrir una app a eleccion del usuario con un chooser
        Button button9 = (Button)findViewById(R.id.button9);
        button9.setOnClickListener((arg0) -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mestreacasa.gva.es/web/iesserraperenxisa/"));
            Intent chooser = Intent.createChooser(intent, "Elige la app que quieres usar");

            //Comprobamos de antemano que el Intent podrá ser gestionado sin petar
            //También se podría poner un try/catch
            if (intent.resolveActivity(getPackageManager()) != null){
                startActivity(chooser);
            }
        });

    }
}