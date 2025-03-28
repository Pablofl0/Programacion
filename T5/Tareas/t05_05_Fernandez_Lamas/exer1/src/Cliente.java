public class Cliente extends Usuario{
    

    public Cliente(String nombreUsuario, String contrasenhaUsuario) throws ExcepcionGeneral{
        super(nombreUsuario, contrasenhaUsuario, TipoUsuario.Cliente);
    }
}
