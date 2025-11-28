La aplicación "PorcSmart Beta" es una calculadora de porcentajes desarrollada por Magic Code Inc, diseñada para realizar cálculos de porcentaje de manera rápida, sencilla y precisa. Está construida como una aplicación Android nativa utilizando Java, con una interfaz de usuario basada en pestañas (tabs) que permite diferentes modos de cálculo. A continuación, te detallo su funcionalidad de manera exhaustiva:

<center><img width="240" height="240" alt="imagen" src="https://github.com/user-attachments/assets/c2d5dfec-a5c9-46ee-bb32-11d006015beb" /></center>

*Estructura General de la App*
- Nombre de la App: PorcSmart Beta
- Desarrollador: Magic Code Inc
- Plataforma: Android (compatible con versiones modernas, incluyendo soporte para edge-to-edge en Android 15+)
- Monetización: Incluye anuncios de AdMob (banners) para generar ingresos.
- Idioma: Principalmente en español, con algunos elementos en inglés.
- Versión: Beta (promociona una versión Pro disponible en Google Play).

La app utiliza un diseño moderno con una barra de herramientas (toolbar), pestañas (tabs) y un ViewPager para navegar entre secciones. Cada pestaña cambia el color de la interfaz (amarillo, azul, rosa) para una experiencia visual diferenciada. Incluye un menú de opciones con "Acerca de", "Política de Privacidad" (enlace a un sitio web) y un enlace directo a la versión Pro.

*Funcionalidades Principales*
La app se divide en *3 pestañas principales*, cada una enfocada en un tipo de cálculo de porcentaje. Todas comparten elementos comunes como:
- Campo de Valor Inicial: Para ingresar el número base.
- Campo de Porcentaje: Solo visible en la primera pestaña; en las otras está oculto y usa un porcentaje fijo.
- Selector de Formato Decimal: Un spinner con opciones para mostrar resultados en formatos como 0, 0.00, 0.000 o 0.0000 decimales.
- Campo de Resultado: Muestra el cálculo en tiempo real a medida que se escribe.
- Actualización Automática: Los resultados se calculan y actualizan instantáneamente usando TextWatchers en los campos de entrada.

*Pestaña 1: "Simple"*
- Propósito: Cálculo básico de porcentaje.
- Entradas:
  - Valor Inicial (número base).
  - Porcentaje (valor porcentual a calcular).
- Cálculo: Calcula el monto porcentual directamente: `Resultado = (Valor Inicial × Porcentaje) / 100`.
- Ejemplo: Si ingresa 100 como valor inicial y 20% como porcentaje, el resultado es 20.00 (el 20% de 100).
- Uso: Ideal para cálculos generales, como descuentos, intereses o proporciones simples.

<center><img width="302" height="639" alt="imagen" src="https://github.com/user-attachments/assets/d6a7f93e-8af1-4682-a5df-cfcd85342d39" /></center>


*Pestaña 2: "5% Incremento"*
- Propósito: Aplicar un incremento fijo del 5% al valor inicial.
- Entradas:
  - Valor Inicial (solo este campo es editable; el porcentaje está fijo en 5%).
- Cálculo:
  - Incremento = (Valor Inicial × 5) / 100
  - Resultado Final = Valor Inicial + Incremento
- Salida: Muestra el valor final y el monto del incremento en líneas separadas, ej.: "105.00\nIncremento de: +5.00".
- Uso: Útil para calcular aumentos rápidos, como ajustes de precios o bonos.

<center><img width="302" height="639" alt="imagen" src="https://github.com/user-attachments/assets/33b72082-a76b-493b-9c93-35789bce0b06" /></center>

*Pestaña 3: "5% Decremento"*
- Propósito: Aplicar un descuento fijo del 5% al valor inicial.
- Entradas:
  - Valor Inicial (solo este campo es editable; el porcentaje está fijo en 5%).
- Cálculo:
  - Decremento = (Valor Inicial × 5) / 100
  - Resultado Final = Valor Inicial - Decremento
- Salida: Muestra el valor final y el monto del decremento en líneas separadas, ej.: "95.00\nDecremento de: -5.00".
- Uso: Perfecto para calcular descuentos, rebajas o reducciones.

<center><img width="304" height="639" alt="imagen" src="https://github.com/user-attachments/assets/4e9b05b1-225d-4c61-9bd4-150b37c62253" /></center>

*Características Técnicas y de Diseño*
- Arquitectura: Basada en Fragments con ViewPager para navegación por pestañas. Usa AppCompatActivity para compatibilidad.
- UI/UX:
  - Diseño responsivo con soporte para edge-to-edge (pantallas modernas sin bordes).
  - Colores dinámicos que cambian según la pestaña seleccionada.
  - Spinner personalizado para selección de formato decimal.
  - Toolbar sin título, con menú de opciones.
- Anuncios: Integración con Google AdMob para banners publicitarios, con ID de app configurado.
- Permisos: Requiere acceso a internet para anuncios y ID de publicidad.
- Almacenamiento: Soporte para backup y extracción de datos (reglas configuradas en XML).
- Dependencias: Usa librerías estándar de Android, incluyendo Google Mobile Ads y ViewPager.
- Pruebas: Incluye pruebas unitarias (ExampleUnitTest) e instrumentadas (ExampleInstrumentedTest).

*Propósito y Casos de Uso*
Según la descripción oficial: "PorcenSmart es la herramienta definitiva para realizar cálculos de porcentaje de manera rápida y sencilla. Esta aplicación versátil y amigable permite a los usuarios calcular incrementos y descuentos de porcentaje con precisión. Ya sea para negocios, finanzas personales o tareas escolares, PorcSmart es la elección perfecta."

Es ideal para:
- Negocios: Cálculos de márgenes, descuentos o aumentos de precios.
- Finanzas Personales: Intereses, ahorros o presupuestos.
- Educación: Ejercicios matemáticos o enseñanza de porcentajes.
- Diario: Cálculos rápidos sin necesidad de calculadora física.

La versión Beta parece ser gratuita con anuncios, mientras que la Pro (enlace en el menú) probablemente ofrece funciones premium sin ads o adicionales.

Si necesitas más detalles sobre algún aspecto específico, ¡házmelo saber!

Acá dejo el enlace de la app: https://play.google.com/store/apps/details?id=com.magiccodeinc.porcsmartbeta&pcampaignid=web_share
