package ed2026.PI_I.G510;

public class Cola<T> {

   private Nodo<T> frente = null;
   private Nodo<T> fin = null;
   private int tamanio = 0;

   public Cola() {
   }

   public boolean esVacia() {
      return this.frente == null;
   }

   public void encolar(T dato) {
      Nodo<T> nuevo = new Nodo<>(dato);
      if (this.esVacia()) {
         this.frente = nuevo;
      } else {
         this.fin.siguiente = nuevo;
      }
      this.fin = nuevo;
      ++this.tamanio;
   }

   public T desencolar() {
      if (this.esVacia()) {
         return null;
      } else {
         T dato = (T) this.frente.dato;
         this.frente = this.frente.siguiente;

         // Si la cola quedo vacia, se limpia la referencia a 'fin'
         if (this.frente == null) {
            this.fin = null;
         }

         --this.tamanio;
         return dato;
      }
   }

   public T verFrente() {
      return (T) (this.esVacia() ? null : this.frente.dato);
   }

   public int getTamanio() {
      return this.tamanio;
   }
}
