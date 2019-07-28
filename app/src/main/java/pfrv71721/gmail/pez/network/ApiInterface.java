package pfrv71721.gmail.pez.network;


import pfrv71721.gmail.pez.ui.main.login.data.LoginResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("login.php")
    Call<LoginResponse> signInWithEmailAndPassword(@Query("email") String user, @Query("password") String password);

//    @GET("getMedicalAppointments.php")
//    Call<List<DoctorList>> getMedicalAppointments(@Query("idEmpleado") int idEmpleado);

    //metodo get
    @GET("guardarObservacion.php")
    Call<LoginResponse> saveObservation(@Query("observacion") String observation, @Query("idCitasMedicas") int id);




}
