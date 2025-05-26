public
class
ContaBancaria
{
    private
    String titular;
    private
    double
            saldo;
    public
    ContaBancaria
            (String titularInicial)
    { titular = titularInicial;
        saldo =
                0.0
        ; }
    public
    void
    depositar
            (
                    double
                            valor)
    {
        if
        (valor >
                0
        ) { saldo += valor; } }
    public
    void
    sacar
            (
                    double
                            valor)
    {
        if
        (valor >
                0
                && valor <= saldo) { saldo -= valor; } }
    public
    double
    consultarSaldo
            ()
    {
        return
                saldo; }}