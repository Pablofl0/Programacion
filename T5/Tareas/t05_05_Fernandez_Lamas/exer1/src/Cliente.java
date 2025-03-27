public class Cliente extends Usuario{
    

    public Cliente(String nombreUsuario, String contrasenhaUsuario) throws ExcepcionGeneral{
        setNombreUsuario(nombreUsuario);
        setContrasenhaUsuario(contrasenhaUsuario);
    }
}
