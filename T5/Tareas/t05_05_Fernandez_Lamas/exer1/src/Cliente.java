public class Cliente extends Usuario{
    

    public Cliente(String nombreUsuario, String contrasenhaUsuario, String contrasenhaUsuarioConfirmacion) throws ExcepcionGeneral{
        super(nombreUsuario, contrasenhaUsuario, contrasenhaUsuarioConfirmacion, TipoUsuario.Cliente);
    }
}
