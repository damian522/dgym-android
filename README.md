# D GYM Android — Proyecto inicial

Este repositorio contiene el esqueleto inicial de la app D GYM (Kotlin + Jetpack Compose).

Qué incluye en esta primera entrega:

- SplashScreen composable (app/src/main/java/com/dgym/app/ui/SplashScreen.kt) con la animación esqueleto (zoom y texto).
- Estructura propuesta para la app (MVVM) y dependencias a integrar: Hilt, Retrofit, Coil, Room.
- Carpeta `assets/` para subir el logo original y las versiones optimizadas.

Siguientes pasos que completaré tras esta entrega:

1. Integrar Firebase demo (Auth, Firestore, Storage) y crear la cuenta moderador de prueba.
2. Subir assets optimizados (PNG) y mockups Figma/PNG.
3. Implementar navegación a la pantalla catálogo y al acceso moderador.

Instrucciones rápidas para ejecutar el proyecto localmente (cuando esté completo):

- Abrir Android Studio Arctic Fox o superior.
- Clonear el repo y abrir la carpeta `app`.
- Añadir el `google-services.json` en `app/` cuando conectemos con Firebase.
- Build & Run en un emulador o dispositivo Android.

Demo de acceso (solo para pruebas)

Para facilitar pruebas desde dispositivos móviles sin conectar Firebase inmediatamente, el proyecto incluye en el código una credencial demo (sólo para desarrollo):

- Email: djyc2010foxy@gmail.com
- Contraseña: TempPass#1234

IMPORTANTE: Esta credencial está incluida solo para demostración y no es segura. El acceso demo debe eliminarse antes de publicar la app en producción o cuando se integre Firebase real.

